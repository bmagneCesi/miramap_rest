package app.ctrl;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractController {
	
	protected ObjectMapper mapper = new ObjectMapper();
}
