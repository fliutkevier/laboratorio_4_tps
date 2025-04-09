package ejercicio2;

public class MainEjercicio2 {
	public static void main(String[] args) {
		ProductoCongelado productoCongelado = new ProductoCongelado("12-04-2025", 14, "-10°C");
		ProductoFresco productoFresco = new ProductoFresco("16-03-2026", 11, "10-01-1960", "Perú");
		ProductoRefrigerado productoRefrigerado = new ProductoRefrigerado("04-12-2035", 18, "B1273A3");
		
		System.out.println(productoCongelado.toString());
		System.out.println(productoFresco.toString());
		System.out.println(productoRefrigerado.toString());
	}
}
