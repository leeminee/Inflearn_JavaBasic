package ref.ex;

import java.util.Scanner;

public class ProductOrderMain3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int amount = sc.nextInt();
        sc.nextLine();

        ProductOrder[] productOrders = new ProductOrder[amount];

        for (int i = 0; i < amount; i++) {
            System.out.println(i+1+"번째 주문 정보를 입력하세요.");
            System.out.print("상품명:");
            String productName = sc.nextLine();
            System.out.print("가격:");
            int price = sc.nextInt();
            System.out.print("수량:");
            int quantity = sc.nextInt();
            sc.nextLine();

            productOrders[i] = createOrder(productName, price, quantity);
        }

        printOrders(productOrders);
        int total = getTotalAmount(productOrders);
        System.out.println("총 결제 금액 : "+total);
    }

    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.productName = productName;
        productOrder.price = price;
        productOrder.quantity = quantity;
        return productOrder;
    }

    static void printOrders(ProductOrder[] productOrders) {
        for(ProductOrder productOrder : productOrders) {
            System.out.println("상품명:"+productOrder.productName+", 가격:"+productOrder.price+", 수량:"+productOrder.quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] productOrders) {
        int totalAmount = 0;
        for(ProductOrder productOrder : productOrders) {
            totalAmount += productOrder.price*productOrder.quantity;
        }
        return totalAmount;
    }
}
