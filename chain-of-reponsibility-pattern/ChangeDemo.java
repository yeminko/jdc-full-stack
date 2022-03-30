interface Handler {

	String handle(int data);

	void setParent(Handler Handler);
}

abstract class BaseHandler implements Handler {

	protected Handler parent;

	public void setParent(Handler handler) {
		this.parent = handler;
	}

	protected abstract boolean canHandle(int data);
}

class EventNumberHandler extends BaseHandler {


	protected boolean canHandle(int data) {
		return data % 2 == 0;
	}

	public String handle(int data) {

		if(canHandle(data)) {
			return "Event Number handler is handled %d".formatted(data);
		}

		if( null != parent) {
			return parent.handle(data);
		}

		return "Cannot handle %d".formatted(data);
	}
}

class OddNumberHandler extends BaseHandler {


	protected boolean canHandle(int data) {
		return data % 2 != 0;
	}

	public String handle(int data) {

		if(canHandle(data)) {
			return "Odd Number handler is handled %d".formatted(data);
		}

		if( null != parent) {
			return parent.handle(data);
		}

		return "Cannot handle %d".formatted(data);
	}
}