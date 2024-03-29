# -*- coding: utf-8 -*-
"""200042156_MATH4544_Lab_02.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/17lEDyo8keEoD-C3V5XY4qLv5qfmFXJti

# **Lab 2 : Direct method of Interpolation**<br>

Interpolation is the process of estimating unknown data that lies within the range of some known data. The simplest interpolation is the **Direct method of Interpolation**. In order to interpolate unknown data, one needs to define a model that would fit the known data and based on that model, one would obtain the unknown data. This model would basically be a function that tries to satisfy the known data points. There can be various types of functions that may satisfy the same given data points, but for interpolation, we usually choose **polynomials** as interpolating functions due to the fact that polynomials are very easy to evaluate, differentiate and integrate.

In today's lab, we will be implementing the Direct method of Interpolation in python. To test our implementation, we will be using the same data that we used during our class lectures. Run the following cell to load the known data points:
"""

t = [0, 10, 15, 20, 22.5, 30]
v = [0, 227.04, 362.78, 517.35, 602.97, 901.67]

import numpy as np
import matplotlib.pyplot as plt

"""##Task 1
Design a utility function that will be called in the `DirectInterpolation` function. The purpose of this function will be to find the $n+1$ closest points to the unknown value $t_{new}$ where we want to interpolate the data, where $n$ is the order of the interpolating polynomial. Understand that the nearest points should be selected such that they bracket the $t_{new}$. The function to be implemented is as follows:
"""

def NearestPoints(t, v, n, t_new):
    differences = [abs(t_i - t_new) for t_i in t]

    sorted_indices = sorted(range(len(differences)), key=lambda i: differences[i])

    nearest_indices = sorted_indices[:n+1]

    t_near = [t[i] for i in nearest_indices]
    v_near = [v[i] for i in nearest_indices]

    return t_near, v_near

"""The above function is supposed to return two vectors, say `t_nearest` and `v_nearest` consisting of $n+1$ elements each. For testing how the function works, we can print the data and see what we are getting. If our implementation is correct, then we should be getting $[15], [362.78]$ for $n=0$. Run the following cell to check this:"""

n = 0
t_new = 16

t_near, v_near = NearestPoints(t, v, n, t_new)
print(t_near)
print(v_near)

n = 1
t_new = 16

t_near, v_near = NearestPoints(t, v, n, t_new)
print(t_near)
print(v_near)

"""The output for $n=1$ should be $[15, 20], [362.78, 517.35]$"""

n = 2
t_new = 16

t_near, v_near = NearestPoints(t, v, n, t_new)
print(t_near)
print(v_near)

"""The output for $n=2$ should be $[15, 20, 10], [362.78, 517.35, 227.04]$

## Task 2
Now your task is to design a generalized function that takes the given data as parameters as well as the order $n$ of the polynomial and uses the *Direct Interpolation* method to interpolate the unknown data at $t_{new}$. The following cell contains the function to be implemented:
"""

def DirectInterpolation(t, v, n, t_new):
    #Write your implementation here.
    t_nearest, v_nearest = NearestPoints(t, v, n, t_new)
    matrix = []
    for i in range(n+1):
        row = []
        for j in range(n+1):
            row.append(t_nearest[i]**j)
        matrix.append(row)
    matrix = np.array(matrix)
    b = np.array(v_nearest)
    f = np.linalg.solve(matrix, b)
    return f

def eval(f, t_new):
    n = len(f)
    val = 0
    for i in range(n):
        val += f[i]*t_new**i
    val = round(val, 2)
    return val

"""Note that the above function will at first need to find a number of closest points to the unknown data $t_{new}$, and this number will vary depending on the order $n$ of the polynomial that we want to use as the interpolating function. So you will have to call the function you implemented in Task 1 inside this function."""

print(eval(DirectInterpolation(t, v, 1, 16),16))

"""For $n=1$, we should get $v(16) = 393.7ms^{-1}$."""

print(eval(DirectInterpolation(t, v, 2, 16),16))

"""For $n=2$, we should get $v(16) = 392.19ms^{-1}$."""

print(eval(DirectInterpolation(t, v, 3, 16),16))

"""For $n=3$, we should get $v(16) = 392.06ms^{-1}$.

##Task 3
Now, test the function using different order of polynomials, setting $n = 1, 2,$ and $3$ and so on and print the absolute relative approximate error at each step. Also generate a plot of Order $(n)$ vs Relative Approximate Error $(|\epsilon_a|\%)$. In case you do not remember how graphs can be plotted in Python, here is a sample code showing how to do it using the `matplotlib` library.
"""

iters = []
errors = []

for i in range(2, 6):
    x_old = eval(DirectInterpolation(t, v, i-1, 16), 16)
    x_new = eval(DirectInterpolation(t, v, i, 16), 16)
    e = abs(1 - x_old/x_new) * 100
    iters.append(i)
    errors.append(e)
plt.plot(iters, errors)
plt.title("Iterations vs errors")
plt.xlabel("Iteration")
plt.ylabel("Errors")
plt.show()

# Write your code here for finding the relative approximate errors for different orders of the polynomial

"""##Task 4
Now, write a function for evaluating the acceleration at $t = 16$
"""

#implement the acceleration function

def acceleration(f, t_new):
  f = f[::-1]
  # print(f)
  n = len(f) - 1
  val = int()
  for i in f:
    val += n * i * (t_new ** (n - 1))
    n -= 1
    if n == 0:
      break
  return val

print(acceleration(DirectInterpolation(t, v, 2, 16), 16))