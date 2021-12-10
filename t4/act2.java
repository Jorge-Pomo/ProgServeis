package t4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class act2 {
	public void descargarArchivo(String url_descargar, String nombreArchivo) {
		System.out.println("Descargando " + url_descargar);
		URL laUrl;
		try {
			laUrl = new URL(url_descargar);
			InputStream is = laUrl.openStream();

			byte[] todo = is.readAllBytes();
			FileOutputStream fos = new FileOutputStream(nombreArchivo);
			fos.write(todo);
			fos.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		act2 gd = new act2();
		String url = "http://localhost:80" + "/web/PDF.pdf";
		String fichero = ".\\src\\t4\\arxius\\PDF.pdf";
		gd.descargarArchivo(url, fichero);
	}

}
