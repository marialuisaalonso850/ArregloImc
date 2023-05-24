import javax.swing.JOptionPane;

public class Procesos {

	String[] listaNombres;
	int[] listaEdades;
	double[] listaPesos;
	double[] listaAlturas;

	public Procesos() {
	}

	public void iniciar() {
		int opc;
		do {
			opc = mostrarMenu();
			validarMenu(opc);
		} while (opc != 5);
	}

	private int mostrarMenu() {
		String menu = "IMC\n";
		menu += "1. Llenar personas\n";
		menu += "2. Imprimir personas\n";
		menu += "3. Imprimir IMC\n";
		menu += "4. Buscar por nombre\n";
		menu += "5. Salir\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu + "Ingrese una opción válida: "));
	}

	public void validarMenu(int opc) {
		switch (opc) {
		case 1:
			crearPersona();
			break;
		case 2:
			imprimirPersona();
			break;
		case 3:
			imprimirImc();
			break;
		case 4:
			buscarNombre();
			break;
		case 5:
			System.out.println("Salir");
			break;
		default:
			System.out.println("Ingrese una opción válida");
			break;
		}
	}

	private void crearPersona() {
		int persona = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas: "));
		listaNombres = new String[persona];
		listaEdades = new int[persona];
		listaPesos = new double[persona];
		listaAlturas = new double[persona];
		for (int i = 0; i < persona; i++) {
			listaNombres[i] = JOptionPane.showInputDialog("Ingrese el nombre: ");
			listaEdades[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad: "));
			listaPesos[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso: "));
			listaAlturas[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura: "));
		}
	}

	private void imprimirPersona() {
		for (int i = 0; i < listaNombres.length; i++) {
			System.out.println("La persona " + listaNombres[i] + " tiene " + listaEdades[i] + " años, pesa "
					+ listaPesos[i] + "kg y mide " + listaAlturas[i] + "m.");
		}
	}

	private void buscarNombre() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
		int indiceEncontrado = -1;
		for (int i = 0; i < listaNombres.length; i++) {
			if (listaNombres[i].equals(nombre)) {
				indiceEncontrado = i;
				System.out.println(listaNombres[i]);
				break;
			}
		}
		if (indiceEncontrado != -1) {
			double imc = calcularImc(indiceEncontrado);
			System.out.println("La persona " + nombre + " tiene un IMC de: " + obtenerCategoriaImc(imc));
		} else {
			System.out.println("La persona " + nombre + " no fue registrada");
		}
	}

	private void imprimirImc() {
		for (int i = 0; i < listaNombres.length; i++) {
			double imc = calcularImc(i);
			System.out.println("La persona " + listaNombres[i] + " tiene un IMC de: " + obtenerCategoriaImc(imc));
		}
	}

	private double calcularImc(int indice) {
		double imc = listaPesos[indice] / (listaAlturas[indice] * listaAlturas[indice]);
		return imc;
	}

	private String obtenerCategoriaImc(double imc) {
		if (imc < 18) {
			return "Anorexia";
		} else if (imc < 20) {
			return "Delgadez";
		} else if (imc < 27) {
			return "Normalidad";
		} else if (imc < 30) {
			return "Obesidad";
		} else if (imc < 35) {
			return "Obesidad grado 2";
		} else if (imc < 40) {
			return "Obesidad grado 3";
		} else {
			return "Obesidad morbida";
		}
	}
}
