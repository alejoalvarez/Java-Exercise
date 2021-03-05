package co.com.alejo.exercise7;

import java.math.BigDecimal;
import java.util.Arrays;
import java.math.RoundingMode;

import java.util.List;

public class StreamsReduceWithMap {

    public static void main(String[] args) {

        List<Invoice> invoices = Arrays.asList(
                new Invoice("A01", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)),
                new Invoice("A02", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)),
                new Invoice("A03", BigDecimal.valueOf(4.99), BigDecimal.valueOf(2))
        );

        BigDecimal sum = invoices.stream()
                .map(x -> x.getQty().multiply(x.getPrice()))    // map
                .reduce(BigDecimal.ZERO, BigDecimal::add);      // reduce

        System.out.println(sum);    // 49.955
        System.out.println(sum.setScale(2, RoundingMode.HALF_UP));  // 49.96

    }

    static class Invoice {

        String invoiceNo;
        BigDecimal price;
        BigDecimal qty;

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getQty() {
            return qty;
        }

        public void setQty(BigDecimal qty) {
            this.qty = qty;
        }

        public Invoice(String invoiceNo, BigDecimal price, BigDecimal qty) {
            this.invoiceNo = invoiceNo;
            this.price = price;
            this.qty = qty;
        }

        public String getInvoiceNo() {
            return invoiceNo;
        }

        public void setInvoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
        }
    }
}
