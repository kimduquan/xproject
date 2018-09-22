package xproject.xcout.shared.helloworld;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

import xproject.xcout.shared.helloworld.HelloWorldFormData;

/**
 * <h3>{@link IHelloWorldService}</h3>
 *
 * @author Admin
 */
@TunnelToServer
public interface IHelloWorldService extends IService {
	HelloWorldFormData load(HelloWorldFormData input);
}
