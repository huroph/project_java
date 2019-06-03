package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 * @version $Id: $Id
 */
public interface IController {

	 /**
	  * Control.
	  */
	 void control();

	 /**
	  * Order perform.
	  *
	  * @param controllerOrder
	  *          the controller order
	  */
	 void orderPerform(ControllerOrder controllerOrder);
}
