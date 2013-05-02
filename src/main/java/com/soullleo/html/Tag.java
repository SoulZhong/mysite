/**
 * 
 */
package com.soullleo.html;

/**
 * @author Soul
 *
 * @date 2012-3-14
 */
public class Tag {
	
	private String charactors;
	private short tagType; //startTag like <div>; endTag like </div>; singleTag like <br/>   
	
	public final static short START = 0;
	public final static short END = 1;
	public final static short SINGLE = 2;
	
/*
	public Tag(){
		
	}*/
	public Tag(String charactors){
		this.charactors = uniform(charactors);
		tagType = judgeType(this.charactors);
	}

	public boolean isCouple(Tag tag) throws Exception{
		
		if(this.toHisPartner().equals(tag)){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean equals(Tag tag){
		if(tag.getCharactors().equals(this)){
			return true;
		}else{
			return false;
		}		
	}
	
	public Tag toHisPartner() throws Exception{
		
		switch(getTagType()){
			case Tag.SINGLE:
				new Exception(this.charactors + " can't change to his partner!");
				break;
			case Tag.START:
				toEndTag();
				break;
			case Tag.END:
				toStartTag();
				break;
		}
			
		
		return this;
	}

	
	private void toStartTag() {
		this.charactors = "<" + this.charactors.substring(2);
	}

	private void toEndTag() {
		this.charactors = "</" + this.charactors.substring(1);
	}

	
	private short judgeType(String charactors) {
		
		if(charactors.endsWith("/>")){
			this.tagType = 2;
		}else if(charactors.startsWith("</")){
			this.tagType = 1;
		}else{
			this.tagType = 0;
		}
		
		return this.tagType;
	}
	
	private String uniform(String charactors) {
		
		//delete attribute;
		if(charactors.indexOf(" ") > 0){
			
		}
				
		//to lower case;
		charactors = charactors.toLowerCase();
		
		return charactors;
	}
	
	
	
	
	public String getCharactors() {
		return charactors;
	}
	public void setCharactors(String charactors) {
		this.charactors = charactors;
	}

	public short getTagType() {
		return tagType;
	}

	public void setTagType(short tagType) {
		this.tagType = tagType;
	}
	

}
