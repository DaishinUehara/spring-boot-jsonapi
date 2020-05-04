package daishin.uehara.display;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daishin.uehara.jpa.model.MDisplay;
import daishin.uehara.jpa.model.MDisplayRepository;
import lombok.Data;

@Service  // サービスクラスに付与。
public class DisplayService {
	
	@Autowired
	private MDisplayRepository mDisplayRepository;
	
	@Data
	public static class AddDTO {
		private String displayName;
	}

	@Data
	public static class DisplayDTO {
		private List<MDisplay> mdisplay;
	}
	
	public Long addDisplay(final AddDTO addDTO) {
		final MDisplay mdisplay = new MDisplay();
		mdisplay.setDisplayName(addDTO.getDisplayName());
		mDisplayRepository.save(mdisplay);
		return Long.valueOf(0);
	}

	public DisplayDTO getDisplay() {
		final List<MDisplay> mdisplay = mDisplayRepository.findAll();
		final DisplayDTO ret = new DisplayDTO();
		ret.setMdisplay(mdisplay);
		return ret;
	}
}
