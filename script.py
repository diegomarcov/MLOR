with open("casosDeError.ml") as f:
	i=1
	for line in f:
		with open(str(i)+".ml","w") as aux:
			aux.write(line)
		i+=1
