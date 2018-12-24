1、对请求进行拦截的方式有三种：
    1.1、通过实现Filter的方式进行拦截；
        能够拿到请求request和返回的response，但是无法拿到具体的Controller类和执行的method；
    1.2、通过springmvc的interceptor拦截器的方式进行拦截；
        能够拿到请求request和返回的response，也能够拿到具体的Controller类和执行的method，但是无法拿到method上的参数
    1.3、通过切片的方式，即AOP方式
        无法拿到request和reponse对象，能够拿到具体的执行的Controller类和执行的方法，也可以拿到方法上的具体参数