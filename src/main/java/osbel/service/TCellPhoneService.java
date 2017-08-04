package osbel.service;

import java.util.List;

import osbel.bean.TCellPhone;


public interface TCellPhoneService {
	
	public List<TCellPhone> getTCellPhoneList(int pageNum, int pageSize);

	public List<TCellPhone> getAllphones();

	public void savePhone(TCellPhone phone);

	public void delPhone(int i);

	public void updatePhone(TCellPhone phone);
	
		

}
