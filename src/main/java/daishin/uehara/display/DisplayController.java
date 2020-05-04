package daishin.uehara.display;

import daishin.uehara.display.DisplayService.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/display")
public class DisplayController {
	
	@Autowired DisplayService displayService;
	
    @RequestMapping("/getall")
    public DisplayDTO all() {
    	DisplayDTO displayDTO=displayService.getDisplay();
        return displayDTO;
    }
    
    @RequestMapping(value="/add",consumes=MediaType.APPLICATION_JSON_VALUE)
    Long addData(@RequestBody AddDTO addDTO) {
    	return displayService.addDisplay(addDTO);
    }
}
