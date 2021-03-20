#include <iostream>

char input[1000001];
int fail[1000001];

int strLen()
{
	int index = 0;
	while (input[index] != '\0') index++;
	return index;
}

int main()
{
	while (1)
	{
		for (register int i = 0; i < 1000001; i++) input[i] = '\0';
		scanf("%s", input);
		int size = strLen();
		if (input[0] == '.' && size == 1) break;
	
		for (register int i = 0; i <= size; i++) fail[i] = 0;
		
		for (register int i = 1,j =0; i < size; i++)
		{
			while (j > 0 && input[i] != input[j]) j = fail[j - 1];

			if (input[i] == input[j]) fail[i] = ++j;
		}

		if (fail[size - 1] ==0 || fail[size - 1] % (size - fail[size-1]) != 0) printf("%d\n", 1);
		else printf("%d\n", fail[size - 1] / (size - fail[size-1])+1);
	}
	return 0;
}