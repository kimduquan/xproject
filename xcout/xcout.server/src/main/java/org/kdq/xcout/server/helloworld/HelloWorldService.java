package org.kdq.xcout.server.helloworld;

import org.kdq.xcout.server.ServerSession;
import org.kdq.xcout.shared.helloworld.HelloWorldFormData;
import org.kdq.xcout.shared.helloworld.IHelloWorldService;

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
