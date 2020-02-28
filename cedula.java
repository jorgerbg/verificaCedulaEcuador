public class cedula {
	
	public static boolean verificarCedula(String cedula) {
		int total = 0;
		int tamanoLongitudCedula = 10;
		int[] coeficientes = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
		int numeroProviancias = 24;
		int tercerdigito = 6;
		if (cedula.matches("[0-9]{"+tamanoLongitudCedula+"}")) {
			int provincia = Integer.parseInt(cedula.charAt(0) + "" + cedula.charAt(1));
			int digitoTres = Integer.parseInt(cedula.charAt(2) + "");
			if ((provincia > 0 && provincia <= numeroProviancias) && digitoTres < tercerdigito) {
				int digitoVerificadorRecibido = Integer.parseInt(cedula.charAt(9) + "");
				for (int i = 0; i < coeficientes.length; i++) {
					int valor = Integer.parseInt(coeficientes[i] + "") * Integer.parseInt(cedula.charAt(i) + "");
					total = valor >= 10 ? total + (valor - 9) : total + valor;
				}
				int digitoVerificadorObtenido = total >= 10 ? (total % 10) != 0 ? 10 - (total % 10) : (total % 10)
						: total;
				if (digitoVerificadorObtenido == digitoVerificadorRecibido) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

}
