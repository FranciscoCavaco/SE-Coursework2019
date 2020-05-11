package coursework;

import java.util.Comparator;

public class PaymentAmountSorter  implements Comparator<Payment>{
	public int compare(Payment p1, Payment p2) {
		if (p1.getAmount() == p2.getAmount())
			return 0;
		else if(p1.getAmount() > p2.getAmount())
			return 1;
		else
			return -1;
	}
}

