#include <cstdio>

int N;

int main()
{
	scanf("%d", &N);
	int div = N / 14;
	int ret = ((N-1) % 14) + 1;

	switch (ret)
	{
	case 1:
		printf("baby\n");
		break;
	case 2:
		printf("sukhwan\n");
		break;
	case 5:
		printf("very\n");
		break;
	case 6:
		printf("cute\n");
		break;
	case 9:
		printf("in\n");
		break;
	case 10:
		printf("bed\n");
		break;
	case 13:
		printf("baby\n");
		break;
	case 14:
		printf("sukhwan\n");
		break;
	}

	if (ret == 3 || ret == 7 || ret == 11)
	{
		printf("tu");
		if (div >= 3) {
			printf("+ru*%d", div + 2);
		}
		else {
			for (register int i = 0; i < div+2; i++) {
				printf("ru");
			}
			printf("\n");
		}
	}
	else if (ret == 4 || ret == 8 || ret == 12)
	{
		printf("tu");
		if (div >= 4) {
			printf("+ru*%d", div + 1);
		}
		else {
			for (register int i = 0; i < div + 1; i++) {
				printf("ru");
			}
			printf("\n");
		}
	}
	return 0;
}