2;
false;
2.0 / 3.0;

fun f x = (false,2.0*3.6/x);
fun f x = (x,false,2.0*3.6/x,x);
fun f x y = (1,y x,x+1);
fun f x y = (1,x,x+1);
fun f x y = (1,y x,x+1,y, [y]);
fun f x y = (1,y x,x+1,y, [x]);
fun f x y = x [y] (1,y);
fun g x y = 1;
f g;