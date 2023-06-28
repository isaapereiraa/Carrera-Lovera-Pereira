/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *Implementacion de las primitivas de un arbol binario de busqueda
 * @author soyis
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
            System.out.println("Indice "+ n.llave +" Valor "+n.contenido);
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
}
