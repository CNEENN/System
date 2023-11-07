package main.java.com.movie.domain;

public class SaleItem {
    /*=============================================================
	create table sale_item(
	   sale_item_id bigint not null auto_increment,
	   ticket_id bigint,
	   sale_ID bigint,
	   sale_item_price numeric(10,2),
	   primary key (sale_item_id)
	);
	==============================================================*/

    private int id;
    private int ticketId;
    private float saleId;
    private int price;


    public SaleItem() {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTicketId() {
        return ticketId;
    }
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    public float getSaleId() {
        return saleId;
    }
    public void setSaleId(float saleId) {
        this.saleId = saleId;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
