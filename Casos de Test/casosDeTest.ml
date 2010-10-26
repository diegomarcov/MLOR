2;
3.4;
"asddas";
[1];
[1													];
false;
nil;
(true,3);
true::nil;
2.0 / 3.0;
4+3*6;
false orelse true;
false andalso true;
(3+4) mod (4 div 2);
"Hola" ^ "mundo";
not (4 = 3);
val a = 1;
a;
a+it+1;
val a = false orelse true;
val a = false orelse not true;
val a = false orelse ("asd" = "dasd");
val a = false andalso a;
val a = [a];
val a = 3::[4,5,6];
val b = 3 + 2 div 5 * 2 - 4 mod 3 + 4;
fun f x y = x<>y;
fun f x = (false,2.0*3.6/x);
fun f x = (x,false,2.0*3.6/x,x);
fun f x y = (1,y x,x+1);
fun f x y = (1,x,x+1);
fun f x y = (1,y x,x+1,y, [y]);
fun f x y = (1,y x,x+1,y, [x]);
fun f x y = x [y] (1,y);
fun g x y = 1;
f g;
fun f (x,y) = x+y+1;
fun f (x,y) = x*y+x*4.0;
fun f (x,y) = x*~y;
fun f x y z = (x 3.0, z y [2],y nil);
fun f x = (1,([(x,[[x,1]],x)],x));
fun momia mo mi a = mo [(mi,"tutankamon"),(a 1 2 3 "mumrah" ^ "larala", "imhotep")] 11.11 + 2012;



fun h x y = (x,y);
fun j x = h (x, [1.0,2.0,3.0]);

.
