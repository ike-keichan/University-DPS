/**
 * The default message type
 * If you want to make an another message type,
 * you can refer this code and make it in the same way.
 * 
 * @author naohaya
 */

public class DefaultMessage implements Message {
	private int source;
	private Object content;

	/*
	 * a new message need source process id and a content
	 */
	DefaultMessage(int src, Object cont) {
		source = src;
		content = cont;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Message#getSource()
	 */
	public int getSource() {
		return source;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Message#setContent(java.lang.Object)
	 */
	public void setContent(Object cont) {
		content = cont;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Message#getContent()
	 */
	public Object getContent() {
		return content;
	}

}
