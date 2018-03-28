# LCD Printer
## About
Java program that prints numbers in style of an LCD screen on the command line.

## Descripción de la solución
El programa consta 3 tres clases:
### Main
Corresponde a la clase principal, donde está el método ```main``` y se invocan los métodos 
que hacen posible la lectura y escritura de datos en la consola.
### InputReader
Esta clase lee los datos ingresados y verifica que estén en el formato esperado para el correcto
funcionamiento del programa
### LCDNumber
Esta clase posee toda la lógica relevante para la solución del problema. Cuando se invoca el método ```printNumber()```
de esta clase se crea una matriz que permite saber qué dígitos se deben imprimir, y que segmentos requiere cada uno para
su correcta impresión. Luego por cada línea que será impresa se itera sobre cada dígito para saber cómo es la línea que se
debera imprimir, consultando la matriz ya explicada. Al final de este ```for``` la línea es impresa.
