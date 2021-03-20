#include <stdio.h>

int arr[4];

int main()
{
	int tc;
	scanf("%d", &tc);
	while (tc--)
	{
		int money;
		scanf("%d", &money);
		arr[0] = money / 25;
		money %= 25;
		arr[1] = money / 10;
		money %= 10;
		arr[2] = money / 5;
		money %= 5;
		arr[3] = money;
		
		for (register int i = 0; i < 4; i++) printf("%d ", arr[i]);
		printf("\n");
	}
	return 0;
}