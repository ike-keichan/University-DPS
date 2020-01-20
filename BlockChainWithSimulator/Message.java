/**
 * Message interface
 * @author naohaya
 */

public interface Message {
	/**
	 * get a message content
	 * @return a message object
	 */
	Object getContent();
	
	/**
	 * set a message content
	 * @param o メッセージの内容
	 */
	void setContent(Object o);
	
	/**
	 * get a source process id
	 * @return a process id as Integer
	 */
	int getSource(); 
    
}
