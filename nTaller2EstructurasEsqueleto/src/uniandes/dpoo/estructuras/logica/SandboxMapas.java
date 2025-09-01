package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
        List<String> valores = new ArrayList<String>();
        
        // Agregar todos los valores del mapa a la lista
        for (String valor : mapaCadenas.values()) {
            valores.add(valor);
        }
        
        // Ordenar lexicográficamente (alfabéticamente)
        Collections.sort(valores);
        
        return valores;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> llaves = new ArrayList<String>();
        
        // Agregar todas las llaves del mapa a la lista
        for (String llave : mapaCadenas.keySet()) {
            llaves.add(llave);
        }
        
        // Ordenar lexicográficamente de mayor a menor usando bubble sort
        for (int i = 0; i < llaves.size() - 1; i++) {
            for (int j = 0; j < llaves.size() - 1 - i; j++) {
                if (llaves.get(j).compareTo(llaves.get(j + 1)) < 0) { // Nota: < para orden descendente
                    // Intercambiar elementos
                    String temp = llaves.get(j);
                    llaves.set(j, llaves.get(j + 1));
                    llaves.set(j + 1, temp);
                }
            }
        }
        
        return llaves;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {

        if (mapaCadenas.isEmpty()) {
            return null;
        }
        
        String primera = null;
        
        // Buscar la cadena lexicográficamente menor
        for (String llave : mapaCadenas.keySet()) {
            if (primera == null || llave.compareTo(primera) < 0) {
                primera = llave;
            }
        }
        
        return primera;
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {

        if (mapaCadenas.isEmpty()) {
            return null;
        }
        
        String ultima = null;
        
        // Buscar la cadena lexicográficamente mayor entre los valores
        for (String valor : mapaCadenas.values()) {
            if (ultima == null || valor.compareTo(ultima) > 0) {
                ultima = valor;
            }
        }
        
        return ultima;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
        Collection<String> llavesMayusculas = new ArrayList<String>();
        
       
        for (String llave : mapaCadenas.keySet()) {
            llavesMayusculas.add(llave.toUpperCase());
        }
        
        return llavesMayusculas;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
        
        List<String> valoresUnicos = new ArrayList<String>();
        
        // recorre todos los valores del mapa
        for (String valor : mapaCadenas.values()) {
            
            boolean yaExiste = false;
            for (String valorExistente : valoresUnicos) {
                if (valorExistente.equals(valor)) {
                    yaExiste = true;
                    break;
                }
            }
            
            if (!yaExiste) {
                valoresUnicos.add(valor);
            }
        }
        
        return valoresUnicos.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
        if (cadena != null && !cadena.trim().isEmpty()) {
            // Invertir la cadena manualmente para crear la llave
            String llave = "";
            for (int i = cadena.length() - 1; i >= 0; i--) {
                llave += cadena.charAt(i);
            }
            
            // Agregar al mapa (llave invertida -> valor original)
            mapaCadenas.put(llave, cadena);
        }
     }
    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
        if (llave != null) {
            mapaCadenas.remove(llave);
        }
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
        if (valor != null) {
            // Invertir la cadena manualmente para crear la llave
            String llave = "";
            for (int i = valor.length() - 1; i >= 0; i--) {
                llave += valor.charAt(i);
            }
            mapaCadenas.remove(llave);
        }
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear();
        
        // Procesar cada objeto de la lista
        if (objetos != null) {
            for (Object objeto : objetos) {
                if (objeto != null) {
                    // Convertir el objeto a String
                    String cadena = objeto.toString();
                    String llave = "";
                    for (int i = cadena.length() - 1; i >= 0; i--) {
                        llave += cadena.charAt(i);
                    }
                    
                    // Agregar al mapa (llave invertida -> valor original)
                    mapaCadenas.put(llave, cadena);
                }
            }
        }
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
        Map<String, String> mapaTemp = new HashMap<>();
        
        // Recorrer todas las entradas
        for (Map.Entry<String, String> entrada : mapaCadenas.entrySet()) {
            String llaveOriginal = entrada.getKey();
            String valor = entrada.getValue();
            
            // Convertir la llave a mayu
            String llaveEnMayusculas = llaveOriginal.toUpperCase();
            
            // Agregar al mapa temporal
            mapaTemp.put(llaveEnMayusculas, valor);
        }
        
        // Limpiar el mapay agregar todas las entradas
        mapaCadenas.clear();
        mapaCadenas.putAll(mapaTemp);
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
        if (otroArreglo == null || otroArreglo.length == 0) {
            return true;
        }
        
        // Obtener todos los valores del mapa
        Collection<String> valoresDelMapa = mapaCadenas.values();
        
        // Verificar que cada elemento del arreglo esté en los valores del mapa
        for (String elemento : otroArreglo) {
            if (elemento == null) {
                // Si hay un null en el arreglo y no hay nulls en el mapa, retorna false
                if (!valoresDelMapa.contains(null)) {
                    return false;
                }
            } else {
                // Verificar si el elemento está en los valores del mapa
                if (!valoresDelMapa.contains(elemento)) {
                    return false;
                } 
            }
        }
        
        // Si llegamos aquí, todos los elementos están en el mapa
        return true;
        
        
        
    }

}
