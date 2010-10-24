fun f x y = (1,y x,x+1);
fun f x y = (1,x,x+1);
fun f x y = (1,y x,x+1,y, [y]);
fun f x y = (1,y x,x+1,y, [x]);
fun f x y = x [y] (1,y);