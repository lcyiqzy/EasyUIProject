package osbel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import osbel.bean.TCellPhone;
import osbel.dao.TCellPhoneMapper;

@Service
public class TCellPhoneServiceImpl implements TCellPhoneService {
	
	@Autowired
	TCellPhoneMapper cellPhoneMapper;

	@Override
	public List<TCellPhone> getTCellPhoneList(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<TCellPhone> list = cellPhoneMapper.selectByExample(null);
		
		return list;
	}

	@Override
	public List<TCellPhone> getAllphones() {
		
		return cellPhoneMapper.selectByExample(null);
	}

	@Override
	public void savePhone(TCellPhone phone) {
		// TODO Auto-generated method stub
		
		TCellPhone cellPhone = new TCellPhone();
		
		cellPhone.setPhoneColor(phone.getPhoneColor());
		cellPhone.setPhoneName(phone.getPhoneName());
		cellPhone.setPhonePrice(phone.getPhonePrice());
		
		
		cellPhoneMapper.insertSelective(cellPhone);
		
	}

	@Override
	public void delPhone(int i) {
		
		cellPhoneMapper.deleteByPrimaryKey(i);
		
	}

	@Override
	public void updatePhone(TCellPhone phone) {

		cellPhoneMapper.updateByPrimaryKeySelective(phone);
	}

}
