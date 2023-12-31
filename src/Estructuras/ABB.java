/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;
import Clases.Historico;
import Clases.Reservas;

/**
 *Implementacion de las primitivas de un arbol binario de busqueda
 * @author  isabella, adrian, alejandra
 */
public class ABB {
    
    public Nodo raiz;
    
    public ABB(){
        raiz = null;
    }

    
    private class Nodo{
        public Nodo padre;
        public Nodo right;
        public Nodo left;
        public int llave;
        public Object contenido;
        
        /**
         * Constructor de la clase
         * @param indice 
         */
        public Nodo(int indice){
            llave = indice;
            right = null;
            left = null;
            padre = null;
            contenido = null;
        }
    }
    
    /**
     * Metodo para insertar un nodo al arbol
     * @param key
     * @param value 
     */
    public void insert(int key, Object value){
        Nodo n = new Nodo(key);
        n.contenido = value;
        
        if (raiz==null){
            raiz=n;
        } else {
            Nodo aux = raiz;
            while(aux!=null){
                n.padre = aux;
                if(n.llave>=aux.llave){
                    aux = aux.right;
                } else {
                    aux = aux.left;
                }
            }
            if (n.llave<n.padre.llave){
                n.padre.left = n;
            } else{
                n.padre.right = n;
            }
        }
    }
    
    /**
     * Metodo para buscar un nodo en el arbol por su indice
     * @param key 
     * @return 
     */
    public Nodo find(int key){
        Nodo aux = raiz;
        while(aux.llave!=key){
            if(key<aux.llave){
                aux = aux.left;
            } else {
                aux = aux.right;
            }
            if (aux==null){
                return null;
            }
        }
        return aux;
    }
    
    /**
     * Para verificar si una llave se encuentra o no en el arbol
     * @param key
     * @return 
     */
    public boolean containsKey(int key) {
        Nodo aux = raiz;
        while(aux.llave!=key){
            if(key<aux.llave){
                aux = aux.left;
            } else {
                aux = aux.right;
            }
            if (aux==null){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Metodo para eliminar un nodo del arbol
     * @param key
     * @return 
     */
    public boolean delete(int key){
        Nodo aux = raiz;
        Nodo padre = raiz;
        boolean esHijoIzq = true;
        while(aux.llave!=key){
            padre = aux;
            if(key<aux.llave){
                esHijoIzq=true;
                aux = aux.left;
                
            } else{
                esHijoIzq = false;
                aux = aux.right;
            }
            if (aux==null){
                return false;
            }
            
        } // fin del while
        
        if (aux.left==null && aux.right==null){
            if (aux==raiz){
                raiz=null;
            } else if(esHijoIzq){
                padre.left=null;
            } else{
                padre.right=null;
            }
            
        } else if(aux.right==null){
            if (aux==raiz){
                raiz=aux.left;
            } else if(esHijoIzq){
                padre.left=aux.left;
            } else{
                padre.right=aux.left;
            }
            
        } else if(aux.left==null){
            if (aux==raiz){
                raiz=aux.right;
            } else if(esHijoIzq){
                padre.left=aux.right;
            } else{
                padre.right=aux.right;
            }
        } else {
           Nodo reemplazo = getReemplazo(aux);
           if(aux==raiz){
               raiz=reemplazo;
           } else if(esHijoIzq){
               padre.left = reemplazo;
           } else {
               padre.right = reemplazo;
           }
           reemplazo.left = aux.left;
        }
        return true;
    }
    
    /**
     * Recorre el arbol de menor a mayor segun el indice
     * @param n 
     */
    public void inorder(Nodo n){
        if (n!=null){
            inorder(n.left);
//            System.out.println("Indice "+ n.llave +" Valor "+n.contenido);
            inorder(n.right);
        }  
    }
    
    /**
     * Recorre el arbol en preorden
     * @param n 
     */
    public void preorder(Nodo n){
        if (n!=null){
            System.out.println("Indice "+ n.llave +" Valor "+n.contenido);
            preorder(n.left);
            preorder(n.right);
        }
    }
    
    /**
     * Recorre el arbol en postorden
     * @param n 
     */
    public void postorder(Nodo n){
        if (n!=null){
            postorder(n.left);
            postorder(n.right);
            System.out.println("Indice "+ n.llave +" Valor "+n.contenido);
        }
    }
    
    /**
     * 
     * @param r
     * @return 
     */
    public Nodo getReemplazo(Nodo r){
        Nodo reemplazarPadre = r;
        Nodo reemplazo = r;
        Nodo aux = r.right;
        while(aux!=null){
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.left;
        }
        if(reemplazo!=r.right){
            reemplazarPadre.left = reemplazo.right;
            reemplazo.right = r.right;
        }
        return reemplazo;
    }
    
    /**
     * Metodo que permite a traves de la cedula hallar los datos de la reserva
     * @param key cedula 
     * @return datos de la reserva en forma de string
    */
     public String getReserva(int key){
        Nodo nodo = find(key);
        if(nodo != null && nodo.contenido instanceof Reservas){
            Reservas reserva = (Reservas) nodo.contenido;
            return reserva.toReservas();
        } else {
            return null;
        }
    }
    
      /**
     * Metodo que permite a traves de la cedula hallar los datos de la reserva
     * @param key cedula 
     * @return datos de la reserva como Object
    */
     public Reservas getContenido(int key){
        Nodo nodo = find(key);
        if(nodo != null && nodo.contenido instanceof Reservas){
            Reservas reserva = (Reservas) nodo.contenido;
            return reserva;
        } else {
            return null;
        }
    }
    
      /**
     * Metodo que permite a traves de la cedula hallar los datos del historico
     * @param key cedula 
     * @return datos del historico como Object
    */ 
    public Historico getContenido1(int key){
        Nodo nodo = find(key);
        if(nodo != null && nodo.contenido instanceof Historico){
            Historico historico = (Historico) nodo.contenido;
            return historico;
        } else {
            return null;
        }
    }
    
    /**
     * Metodo que permite a traves de la cedula obtener el tipo de habitacion de la reserva
     * @param key cedula 
     * @return tipo de habitacion de la reserva
    */ 
    public String obtenerTipoHab(int key){
        Nodo nodo = find(key);
        if(nodo != null && nodo.contenido instanceof Reservas){
            Reservas reserva = (Reservas) nodo.contenido;
            return reserva.getTipo_hab();
        } else {
            return null;
        }
    }
   
    /**
     * Metodo que permite a traves del numero de habitacion obtener una lista con los clientes que estaban en el historico de esa habitacion 
     * @param num_habitacion numero de habitación
     * @return lista de información de los clientes que estuvieron en la habitación
    */ 
    public ArrayList<Historico> getClientesPorHabitacion(int num_habitacion){
        ArrayList<Historico> clientes = new ArrayList<Historico>();
        getClientesPorHabitacionRec(raiz, num_habitacion, clientes);
        return clientes;
    }
    
    /**
     * Metodo recursivo
     * Metodo que permite a traves del numero de habitacion obtener una lista con los clientes que estaban en el historico de esa habitacion 
     * @param num_habitacion numero de habitación
     * @return lista de información de los clientes que estuvieron en la habitación
    */ 
    private void getClientesPorHabitacionRec(Nodo nodo, int num_habitacion, ArrayList<Historico> clientes){
    if (nodo != null) {
        if (nodo.contenido instanceof Historico) {
            Historico historico = (Historico) nodo.contenido;
//            System.out.println("Encontrado objeto Historico con el número de habitación " + historico.getNum_hab());
            if (historico.getNum_hab() == num_habitacion) {
                clientes.add(historico);
            }
        }
        if (nodo.left != null) {
            getClientesPorHabitacionRec(nodo.left, num_habitacion, clientes);
        }
        if (nodo.right != null) {
            getClientesPorHabitacionRec(nodo.right, num_habitacion, clientes);
        }
    }
}


}
