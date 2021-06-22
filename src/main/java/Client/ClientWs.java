package Client;

import java.rmi.RemoteException;

import webservices.Product;
import webservices.ProductsManagerProxy;
public class ClientWs {

	public static void main(String[] args) throws RemoteException  {
		
		
		ProductsManagerProxy proxy = new ProductsManagerProxy();
		
		
		Product produit= new Product((long) 5,"chemise",150.0);
		Product produit1= new Product((long) 17,"pantalon",250.0);
		Product produit2= new Product((long) 20,"veste",650.0);
		
		
		proxy.addProduct(produit);
		proxy.addProduct(produit1);
		proxy.addProduct(produit2);
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("Liste des produits avec informations :");
		for (int i=0; i<proxy.getProducts().length; i++) {
			System.out.println("-------------------------");
			System.out.println("Détails du produit id :"+proxy.getProducts()[i].getId());
			System.out.println("Type du produit :"+proxy.getProducts()[i].getLabel());
			System.out.println("Prix du produit en DH :"+proxy.getProducts()[i].getPrice());
		}
		System.out.println("-----------------------------------------------------------");
		
		//Suuprimer un produit 
		proxy.deleteProduct(17);
		System.out.println("Produit supprimé");
		
		//Verification des changements
		System.out.println("-----------------------------------------------------------");
		System.out.println("Liste des produits avec informations :");
		for (int i=0; i<proxy.getProducts().length; i++) {
			System.out.println("-------------------------");
			System.out.println("Détails du produit id :"+proxy.getProducts()[i].getId());
			System.out.println("Type du produit :"+proxy.getProducts()[i].getLabel());
			System.out.println("Prix du produit en DH :"+proxy.getProducts()[i].getPrice());
		}
		System.out.println("-----------------------------------------------------------");

	}

}