import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.Message;

public class lab1Test {
	
	@Test
	public void testControlbusAdapter() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		MessageChannel controlChannel = ac.getBean("controlChannel", MessageChannel.class);
		PollableChannel msgChannelAdapterOutput = ac.getBean("inboundChannel", PollableChannel.class);
		Message<String> receivedMsg = (Message<String>) msgChannelAdapterOutput.receive(1000);
		assertNull(receivedMsg);
		System.out.println("Message received on channel before adapter started: " + receivedMsg);
		controlChannel.send(new GenericMessage<String>("@producer-file-adapter.start()"));
		receivedMsg = (Message<String>) msgChannelAdapterOutput.receive(1000);
		assertNotNull(receivedMsg);
		System.out.println("Message received on channel adapter started: " + receivedMsg);
		controlChannel.send(new GenericMessage<String>("@producer-file-adapter.stop()"));
		receivedMsg = (Message<String>) msgChannelAdapterOutput.receive(1000);
		assertNull(receivedMsg);
		System.out.println("Message received on channel after adapter stopped: " + receivedMsg);
		ac.close();
	}

	/*@Test
	public void testControlBusMBean() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("spring-integ-context.xml");
		MessageChannel controlChannel = ac.getBean("controlChannel", MessageChannel.class);
		ManagedCounterBean mangedCounterBean = ac.getBean("managedCounterBean", ManagedCounterBean.class);
		assertEquals(mangedCounterBean.getCounter(), 0);
		System.out.println("Value of message counter before sending message to control bus " + mangedCounterBean.getCounter());
		controlChannel.send(new GenericMessage<String>("@managedCounterBean.increment()"));
		assertEquals(mangedCounterBean.getCounter(), 1);
		System.out.println("Value of message counter after sending message to control bus " + mangedCounterBean.getCounter());
		ac.close();

	}
*/
}
