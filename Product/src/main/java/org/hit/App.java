package org.hit;

import org.hit.model.Product;
import org.hit.service.ProductService;
import org.hit.service.ProductServiceImpl;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        ProductService service=new ProductServiceImpl();
        int pid;
        Product product;
        Scanner sc=new Scanner(System.in);
        int ch=0;

        do {
            System.out.println("1-> Add Product 2-> Update Product 3-> Delete Product 4-> Search 5-> Display 6-> Exit");
            ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Enter Product ID, Name and Price : ");
                    service.addProduct(new Product(sc.nextInt(), sc.next(), sc.nextInt()));
                    break;
                case 2:
                    System.out.println("Enter the Product Id to be updated: ");
                    pid=sc.nextInt();
                    product = service.findById(pid);
                    if(product==null){
                        System.out.println("Record Not Found.");
                    }
                    else{
                        System.out.println("Existing Data: ");
                        System.out.println(product);
                        System.out.println("Enter Product Name and Price to update: ");
                        product.setProductName(sc.next());
                        product.setProductPrice(sc.nextInt());
                        service.updateProduct(product);
                        System.out.println("Record updated Successfully : ");
                        System.out.println(product);
                        System.out.println("Current Data is: ");
                        service.findAll().forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.println("Enter Product ID to delete product data: ");
                    pid=sc.nextInt();
                    product=service.findById(pid);
                    if(product==null){
                        System.out.println("Data not found.");
                    }
                    else {
                        service.deleteProduct(pid);
                        System.out.println("The Deleted Data is: ");
                        System.out.println(product);
                        System.out.println("Current Data is : ");
                        service.findAll().forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.println("Enter Product ID to search : ");
                    pid= sc.nextInt();
                    product=service.findById(pid);
                    if(product==null){
                        System.out.println("Data Not Found.");
                    }
                    else {
                        System.out.println(product);
                    }

                    break;
                case 5:
                    System.out.println("The Product Data is : ");
                    service.findAll().forEach(System.out::println);
                    break;
                case 6:
                    break;

            }
        }while (ch!=6);

    }
}
