package selenium.test;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HttpApi {
// get paramentr do na domene app 

	@RequestMapping(path = "/{testCode}", method = RequestMethod.GET)
	public Response Test(@PathVariable("testCode") String testCode) throws IOException, InterruptedException {
		Response testResponse = new Response();

		if (testCode.equals("signUp")) {
			testResponse = SingUp.runTest();
		} else if (testCode.equals("logInTest")) {
			// testResponse = LogIn.runtTest();
		}
		return testResponse;

	}

	// post co ma testowac parametry testowania
}