package com.iboray.lms.domain.vo;

import java.io.Serializable;
import java.util.Set;

public class MResourceVO  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -476991265450315508L;

	private String mresourceno;

    private String mresourcename;

    private String mresourcevalue;

    private String mresourceurl;

    private String fkMresourceno;
    
    private MResourceVO mresourceVOParent;
    
    private Set<MResourceVO> mresourceVOSet;
    private String invalid;
    private String createtime;
    private String updatetime;
//    private List<MResourceVO> mrls;
    public String getMresourceno() {
        return mresourceno;
    }

    public void setMresourceno(String mresourceno) {
        this.mresourceno = mresourceno == null ? null : mresourceno.trim();
    }

    public String getMresourcename() {
        return mresourcename;
    }

    public void setMresourcename(String mresourcename) {
        this.mresourcename = mresourcename == null ? null : mresourcename.trim();
    }

    public String getMresourcevalue() {
        return mresourcevalue;
    }

    public void setMresourcevalue(String mresourcevalue) {
        this.mresourcevalue = mresourcevalue == null ? null : mresourcevalue.trim();
    }

    public String getMresourceurl() {
        return mresourceurl;
    }

    public void setMresourceurl(String mresourceurl) {
        this.mresourceurl = mresourceurl == null ? null : mresourceurl.trim();
    }

    public String getFkMresourceno() {
        return fkMresourceno;
    }

    public void setFkMresourceno(String fkMresourceno) {
        this.fkMresourceno = fkMresourceno == null ? null : fkMresourceno.trim();
    }

	public Set<MResourceVO> getMresourceVOSet() {
		return mresourceVOSet;
	}

	public void setMresourceVOSet(Set<MResourceVO> mresourceVOSet) {
		this.mresourceVOSet = mresourceVOSet;
	}

	public String getInvalid() {
		return invalid;
	}

	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

//	public List<MResourceVO> getMrls() {
//		return mrls;
//	}
//
//	public void setMrls(List<MResourceVO> mrls) {
//		this.mrls = mrls;
//	}

	public MResourceVO getMresourceVOParent() {
		return mresourceVOParent;
	}

	public void setMresourceVOParent(MResourceVO mresourceVOParent) {
		this.mresourceVOParent = mresourceVOParent;
	}


    
    

}