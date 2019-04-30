#!/usr/bin/env python
# -*- coding: utf-8 -*-
'''
Created on 5 abr. 2019
Clase Cuadrado que hereda de la clase Rectangulo.Utilizada para el examen del segundo trimestre
Esta ademas implementa la comparacion entre 2 cuadrados mediante sobrecarga de operadores
@author: d18momoa
'''
from examen2Trim.Rectangulo import Rectangulo

class Cuadrado(Rectangulo):
    """
    Constructor de la clase cuadrado, hereda el constructor de rectangulo, y
    crea en el estado una variable llamada lado, para mejor identificacion de
    los atributos.
    """
    def __init__(self,l):
        super().__init__(l,l)
        self.__lado = l
    """
    Creacion de las propiedades del lado del cuadrado, implementa el setter 
    y el getter de este atributo.En el setter comprueba que su valor este 
    comprendido entre 1 y 10. Ademas, en el setter, se igualan el ancho y el alto
    con el lado, para poder reutilizar el metodo __str__ de la clase padre (Rectangulo).
    """
    @property
    def lado(self):
        return self.__lado
    @lado.setter
    def lado(self, l):
        Cuadrado.__verifica_lado(l)
        self.__lado = l
        self.alto = l 
        self.ancho = l
    
    def __gt__(self, other):
        """Sobrecarga del operador >"""
        if not isinstance(other, Cuadrado):
            raise Exception
        else:
            return (self.lado) > (other.lado)
    def __ge__(self, other):
        """Sobrecarga del operador >="""
        if not isinstance(other, Cuadrado):
            raise Exception
        else:
            return (self.lado) >= (other.lado)
    def __eq__(self, other):
        """Sobrecarga del operador =="""
        if not isinstance(other, Cuadrado):
            raise Exception
        else:
            return (self.lado) == (other.lado)

    """
    Metodo estatico de la clase cuadrado, que comprueba que el lado se encuentre
    entre 1 y 10 y que sea un entero. Si no es un entero lanzara un TypeError y si
    no comprende los valores entre 1 y 10, lanzara un ArithmeticError.
    """     
    @staticmethod
    def __verifica_lado(num):
        if not isinstance(num, int):  # lado no entero
            raise TypeError("Lado no entero", num)
        if (num <= 0 or num >10):
            raise ArithmeticError()    
"""
Main de la clase Cuadrado donde se llevan a cabo las pruebas.
"""
if __name__ == '__main__':
    try:
        c1 = Cuadrado(4)
        c2 = Cuadrado(5)
        print("Pintamos c1:")
        print(c1)
        print("--------------------------------------")
        print("Modificamos para que c1 valga 8")
        c1.lado = 8
        print("Pintamos c1 modificado:")
        print(c1)
        print("--------------------------------------")
        #c1.lado = 11 #Aqui comprobariamos que captura bien la excepcion
        #print(c1)
        #print("--------------------------------------")
        print("Pintamos c2:")
        print(c2)
        print("--------------------------------------")
        
        print("Comparemos dos cuadrados: ")
        print("Tenemos c1 cuyo lado es: "+str(c1.lado))
        print("Y tenemos c2 cuyo lado es: "+str(c2.lado))
        print("c1 > c2: "+str(c1 > c2))
        print("c1 < c2: "+str(c1 < c2))
        print("c1 == c2: "+str(c1 == c2))
        print("c1 != c2: "+str(c1 != c2))
        print("c1 <= c2: "+str(c1 <= c2))
        print("c1 >= c2: "+str(c1 >= c2))
        print("--------------------------------------")
        print("Creo c3, siendo identico a c2 y los comparo:")
        c3 = c2
        print("Tenemos c2 cuyo lado es: "+str(c2.lado))
        print("Y tenemos c3 cuyo lado es: "+str(c3.lado))
        print("c2 > c3: "+str(c2 > c3))
        print("c2 < c3: "+str(c2 < c3))
        print("c2 == c3: "+str(c2 == c3))
        print("c2 != c3: "+str(c2 != c3))
        print("c2 <= c3: "+str(c2 <= c3))
        print("c2 >= c3: "+str(c2 >= c3))
    except ArithmeticError:
        print("Error, el lado del cuadrado debe estar comprendido entre 1 y 10")
    except TypeError:
        print("Error. Comprueba que el lado sea un valor entero.")
    except:
        print("Error. Solo puedes comparar objetos de tipo Cuadrado entre si")