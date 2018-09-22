package xproject.xcout.server.helloworld;

import xproject.xcout.server.ServerSession;
import xproject.xcout.shared.helloworld.HelloWorldFormData;
import xproject.xcout.shared.helloworld.IHelloWorldService;

/**
 * <h3>{@link HelloWorldService}</h3>
 *
 * @author Admin
 */
public class HelloWorldService implements IHelloWorldService {

	@Override
	public HelloWorldFormData load(HelloWorldFormData input) {
		StringBuilder msg = new StringBuilder();
		msg.append("Hello ").append(ServerSession.get().getUserId()).append('!');
		input.getMessage().setValue(msg.toString());
		return input;
	}
}
