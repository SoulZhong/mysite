/**
 * 
 */
package com.soullleo.html;

import java.util.Stack;

/**
 * @author Soul
 *
 * @date 2012-3-14
 */
public class KeepStructureHTMLParser{
	
	
	private static final char TAG_START = '<';
	private static final char TAG_END = '>';
	private static int length = 400;
	
	public static String parse(String html) {
		
		StringBuilder result = new StringBuilder();
		
		int parsedLength = 0;
		
		int position = 0;
		
		boolean tagStart = false;
		StringBuilder tag = new StringBuilder();
		
		Stack<Tag> tagStack = new Stack<Tag>();
		
		
		while(parsedLength < length && position < html.length()){
			
			char c = html.charAt(position++);
			
			//judge tag char by char
			switch (c){
				case TAG_START:
					tagStart = true;
					tag = new StringBuilder();
					tag.append(c);
					result.append(c);
					break;
				case TAG_END:
					tagStart = false;
					tag.append(c);
					result.append(c);
					
					Tag standardTag = new Tag(tag.toString());
					
					//to ensure the tags are couple
					switch(standardTag.getTagType()){
						case Tag.START:
							tagStack.push(standardTag);
							break;
						case Tag.END:
							tagStack.pop();
							break;
						
					}
					break;
				default:
					if(tagStart){
						tag.append(c);
					}
					parsedLength++;
					result.append(c);
			}

		}
		
		//delete unpaired '<' tag
		if(tagStart){
			result = result.delete(result.lastIndexOf("<"), result.length());
		}
		
		//make up all single '<' tag
		while(!tagStack.isEmpty()){
			try {
				result.append(tagStack.pop().toHisPartner().getCharactors());				
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
					
		return result.toString();
	}

}