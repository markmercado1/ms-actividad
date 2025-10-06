import math

def combinacion(n, r):
    if r > n or n < 0 or r < 0:
        return "No es posible calcular C(n, r) con esos valores"
    return math.factorial(n) // (math.factorial(r) * math.factorial(n - r))

# Programa principal
n = int(input("Ingrese el valor de n: "))
r = int(input("Ingrese el valor de r: "))

resultado = combinacion(n, r)
print("El resultado es:", resultado)
