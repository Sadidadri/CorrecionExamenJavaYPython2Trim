#!/usr/bin/env python
# -*- coding: utf-8 -*-
'''
Created on 5 abr. 2019
Clase Rectangulo creada para el examen del 2 Trimestre
@author: d18momoa
'''

class Rectangulo:
    """
    Constructor de la clase rectangulo, recibe por parametros dos enteros que conforman
    el ancho y el alto. Se verifican que los parametros sean correctos para poder asignarlos.
    """
    def __init__(self,ancho,alto):
        Rectangulo.__verifica_lado(ancho)
        Rectangulo.__verifica_lado(alto)
        self.__ancho = ancho
        self.__alto = alto
    """
    Creacion de las propiedades del ancho del rectangulo, implementa el setter 
    y el getter de este atributo.En el setter comprueba que su valor este 
    comprendido entre 1 y 10.
    """
    @property
    def ancho(self):
        return self.__ancho
    @ancho.setter
    def ancho(self, an):
        Rectangulo.__verifica_lado(an)
        self.__ancho = an
    """
    Creacion de las propiedades del alto del rectangulo, implementa el setter 
    y el getter de este atributo.En el setter comprueba que su valor este 
    comprendido entre 1 y 10.
    """
    @property
    def alto(self):
        return self.__alto
    @alto.setter
    def alto(self, al):
        Rectangulo.__verifica_lado(al)
        self.__alto = al
    """
    Devuelve una cadena de texto con el rectangulo pintado, de manera
    que cuando se muestre el objeto en pantalla, se vea su representacion
    grafica.
    """
    def __str__(self):
        cadena = ""
        cadena += "*"*self.ancho+"\n"
        if(self.alto == 2):
            cadena += "*"*self.ancho+"\n"
        elif(self.alto > 2):
            for i in range(0,self.alto-2):
                cadena+= "*"
                cadena+= " "*(self.ancho-2)
                cadena+= "*\n"
            cadena += "*"*self.ancho+"\n"
        return cadena
    """
    Metodo estatico de la clase cuadrado, que comprueba que el lado se encuentre
    entre 1 y 10 y que sea un entero. Si no es un entero lanzara un TypeError y si
    no comprende los valores entre 1 y 10, lanzara un ArithmeticError.
    Nos servira para verificar tanto el alto, como el ancho del Rectangulo.
    """
    @staticmethod
    def __verifica_lado(num):
        if not isinstance(num, int):  # lado no entero
            raise TypeError("Lado no entero", num) #Lanzo esta excepcion si el parametro introducido no es un entero.
        if (num <= 0 or num >10):
            raise ArithmeticError() #Lanzo esta excepcion que es similar al ArithmeticException de Java

"""
Main de la clase Rectangulo donde se llevan a cabo las pruebas.
"""
if __name__ == '__main__':
    try:
        r1 = Rectangulo(3,4)
        r2 = Rectangulo(5,10)
        #Descomentando la linea de abajo capturamos el ArithmeticError
        #r3 = Rectangulo(11,3)
        #Descomentando la linea de abajo capturamos el TypeError
        #r4 = Rectangulo(4.5,8)
        print("Pintamos el primer rectangulo cuyos datos son:")
        print("Ancho: "+str(r1.ancho))
        print("Alto: "+str(r1.alto))
        print(r1)
        print("--------------------------------------\n")
        print("Pintamos el segundo rectangulo cuyos datos son:")
        print("Ancho: "+str(r2.ancho))
        print("Alto: "+str(r2.alto))
        print(r2)
        print("--------------------------------------\n")
        print("Modifico el alto del r2 a 4")
        r2.alto = 4
        print("Muestro r2 modificado:")
        print(r2)
    except ArithmeticError:
        print("Error, los valores del rectangulo deben estar comprendidos entre 1 y 10")
    except TypeError:
        print("Error. Comprueba que el ancho y el alto sean valores enteros.")
    