using System.IO;
using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.FileProviders;
using XWebApplication.SignalR;
using XWebApplication.Auth;
using XSystem;
using XSystem.XInternal;
using XSystem.XReflection.XInternal;
using XSystem.XComponentModel.XInternal;
using XSystem.XComponentModel;

namespace XWebApplication
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.Configure<CookiePolicyOptions>(options =>
            {
                // This lambda determines whether user consent for non-essential cookies is needed for a given request.
                options.CheckConsentNeeded = context => true;
                options.MinimumSameSitePolicy = SameSiteMode.None;
            });
            services.AddDistributedMemoryCache();
            services.AddMemoryCache();
            services.AddDirectoryBrowser();
            services.AddLocalization(options => options.ResourcesPath = "Resources");
            services.AddMvc()
                .SetCompatibilityVersion(CompatibilityVersion.Version_2_1)
                .AddViewLocalization();
            services.AddSignalR();
            services.AddAuthentication(CookieAuthenticationDefaults.AuthenticationScheme).AddCookie(options =>
            {
                options.LoginPath = "/using";
                options.LogoutPath = "/return";
                options.AccessDeniedPath = "/";
            });
            services.AddAuthorization(options =>
            {
                options.AddPolicy("Type", policy =>
                    policy.Requirements.Add(new XTypeAuthorizationRequirement()));
                options.AddPolicy("object", policy =>
                    policy.Requirements.Add(new XObjectAuthorizationRequirement()));
                options.AddPolicy("new", policy =>
                    policy.Requirements.Add(new XConstructorInfoAuthorizationRequirement()));
                options.AddPolicy("Assembly", policy =>
                    policy.Requirements.Add(new XAssemblyAuthorizationRequirement()));
            });
            services.AddSingleton<IAuthorizationHandler, XTypeAuthorizationHandler>();
            services.AddSingleton<IAuthorizationHandler, XObjectAuthorizationHandler>();
            services.AddSingleton<IAuthorizationHandler, XConstructorInfoAuthorizationHandler>();
            services.AddSingleton<IAuthorizationHandler, XAssemblyAuthorizationHandler>();
            X x = new XInternal();
            x.XAssembly = XAssemblyInternal.XNew;
            XTypeConverter typeConverter = new XObjectConverterInternal(x);
            services.AddSingleton(typeof(X), x);
            services.AddSingleton(typeof(XTypeConverter), typeConverter);
            services.AddSession(options =>
            {
                options.Cookie.IsEssential = true;
            });
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/XException");
                app.UseHsts();
            }
            app.UseRequestLocalization("en-US", "vi-VN", "ja-JP");
            app.UseHttpsRedirection();
            app.UseStaticFiles();
            app.UseStaticFiles(new StaticFileOptions
            {
                FileProvider = new PhysicalFileProvider(
                    Path.Combine(Directory.GetCurrentDirectory(), "System-IO/File")),
                RequestPath = "/System-IO/File"
            });
            app.UseDirectoryBrowser(new DirectoryBrowserOptions
            {
                FileProvider = new PhysicalFileProvider(
            Path.Combine(Directory.GetCurrentDirectory(), "System-IO/Directory")),
                RequestPath = "/System-IO/Directory"
            });

            app.UseCookiePolicy();
            app.UseSignalR(routes =>
            {
                routes.MapHub<XTypeHub>("/Syxtem/Type");
                routes.MapHub<XObjectHub>("/Syxtem/Object");
            });
            app.UseAuthentication();
            app.UseSession();
            app.UseMvc();
        }
    }
}
