#include <stdio.h>
#include <string.h>
char A[100005], B[100005];
int main(void)
{
	int le1, le2, len1, len2, i, j, check = 0, c;
	scanf("%s %s", A, B);

	if (A[0] == '-')
	{
		if (B[0] == '-')//A, B 모두 음수
		{
			len1 = le1 = strlen(A) - 1;
			len2 = le2 = strlen(B) - 1;
			for (i = 0; i < le1; i++)
				A[i + 1] -= 48;
			for (i = 0; i < le2; i++)
				B[i + 1] -= 48;
			if (len1 >= len2)//A가 B보다 길이가 길거나 같은 경우
			{
				for (i = 0; i < len2; i++)
				{
					A[le1 - i] = A[le1 - i] + B[le2 - i];
					if (A[le1 - i] >= 10)
					{
						if (le1 - i == 1)
							continue;
						else
						{
							c = A[le1 - i] / 10;
							A[le1 - i] -= c * 10;
							A[le1 - i - 1] += c;
						}
					}
				}
				for (; i < len1; i++)//해당 루프는 만약 직전 줄까지의 코드에서 마지막으로 더해진 두 수가 10인 경우를 계산하기 위한 코드입니다.
				{
					if (A[le1 - i] >= 10)
					{
						if (le1 - i == 1)
							continue;
						else
						{
							c = A[le1 - i] / 10;
							A[le1 - i] -= c * 10;
							A[le1 - i - 1] += c;
						}
					}
				}
				printf("-");
				for (i = 1; i <= le1; i++)
					printf("%d", A[i]);
				printf("\n");
			}
			else//A가 B보다 길이가 짧은 경우(A, B모두 음수)
			{
				for (i = 0; i < len1; i++)
				{
					B[le2 - i] = B[le2 - i] + A[le1 - i];
					if (B[le2 - i] >= 10)
					{
						if (le2 - i == 1)
							continue;
						else
						{
							c = B[le2 - i] / 10;
							B[le2 - i] -= c * 10;
							B[le2 - i - 1] += c;
						}
					}
				}
				for (; i < len2; i++)//직전까지의 줄에서 마지막 합이 10인 경우입니다.
				{
					if (B[le2 - i] >= 10)
					{
						if (le2 - i == 1)
							continue;
						else
						{
							c = B[le2 - i] / 10;
							B[le2 - i] -= c * 10;
							B[le2 - i - 1] += c;
						}
					}
				}
				printf("-");
				for (i = 1; i <= le2; i++)
					printf("%d", B[i]);
				printf("\n");
			}
		}
		else//A는 음수, B는 양수
		{
			len1 = le1 = strlen(A) - 1;
			len2 = le2 = strlen(B);
			for (i = 0; i < le1; i++)
				A[i + 1] -= 48;
			for (i = 0; i < le2; i++)
				B[i] -= 48;
			if (len1 > len2)//A의 절댓값이 B의 절댓값보다 큼을 자릿수로 알 수 있으면
			{
				for (i = 0; i < le2; i++)
				{
					A[le1 - i] = A[le1 - i] - B[le2 - i - 1];
					if (A[le1 - i] < 0)
					{
						A[le1 - i] += 10;
						A[le1 - i - 1] -= 1;
					}
				}
				printf("-");
				for (i = 0; i < le1; i++)
				{
					if (A[i + 1] == 0 && check == 0)
						continue;
					else
					{
						check = 1;
						printf("%d", A[i + 1]);
					}
				}
				printf("\n");
			}
			else if (len2 > len1)//B의 절댓값이 A의 절댓값보다 큼을 자릿수로 알 수 있다면
			{
				for (i = 0; i < le1; i++)
				{
					B[le2 - i - 1] = B[le2 - i - 1] - A[le1 - i];
					if (B[le2 - i - 1] < 0)
					{
						B[le2 - i - 1] += 10;
						B[le2 - i - 2] -= 1;
					}
				}
				for (i = 0; i < le2; i++)
				{
					if (B[i] == 0 && check == 0)
						continue;
					else
					{
						check = 1;
						printf("%d", B[i]);
					}
				}
				printf("\n");
			}
			else if (strcmp(A + 1, B) == 1) //A의 절댓값이 B의 절댓값보다 크다면
			{
				for (i = 0; i < le1; i++)
				{
					A[le1 - i] = A[le1 - i] - B[le2 - i - 1];
					if (A[le1 - i] < 0)
					{
						A[le1 - i] += 10;
						A[le1 - i - 1] -= 1;
					}
				}
				printf("-");
				for (i = 0; i < le1; i++)
				{
					if (A[i + 1] == 0 && check == 0)
						continue;
					else
					{
						check = 1;
						printf("%d", A[i + 1]);
					}
				}
				printf("\n");
			}
			else if (strcmp(A + 1, B) == -1) //A의 절댓값이 B의 절댓값보다 작다면
			{
				for (i = 0; i < le2; i++)
				{
					B[le2 - i - 1] = B[le2 - i - 1] - A[le1 - i];
					if (B[le2 - i - 1] < 0)
					{
						B[le2 - i - 1] += 10;
						B[le2 - i - 2] -= 1;
					}
				}
				for (i = 0; i < le2; i++)
				{
					if (B[i] == 0 && check == 0)
						continue;
					else
					{
						check = 1;
						printf("%d", B[i]);
					}
				}
				printf("\n");
			}
			else//두 수의 절댓값이 같다면
				printf("0\n");
		}
	}
	else
	{
		if (B[0] == '-')//A는 양수, B는 음수
		{
			len1 = le1 = strlen(A);
			len2 = le2 = strlen(B) - 1;
			for (i = 0; i < le1; i++)
				A[i] -= 48;
			for (i = 0; i < le2; i++)
				B[i + 1] -= 48;
			if (len1 > len2)//A의 절댓값이 B의 절댓값보다 큼을 자릿수로 알 수 있으면
			{
				for (i = 0; i < le2; i++)
				{
					A[le1 - i - 1] = A[le1 - i - 1] - B[le2 - i];
					if (A[le1 - i - 1] < 0)
					{
						A[le1 - i - 1] += 10;
						A[le1 - i - 2] -= 1;
					}
				}
				for (i = 0; i < le1; i++)
				{
					if (A[i] == 0 && check == 0)
						continue;
					else
					{
						check = 1;
						printf("%d", A[i]);
					}
				}
				printf("\n");
			}
			else if (len2 > len1)//B의 절댓값이 A의 절댓값보다 큼을 자릿수로 알 수 있다면
			{
				for (i = 0; i < le1; i++)
				{
					B[le2 - i] = B[le2 - i] - A[le1 - i - 1];
					if (B[le2 - i] < 0)
					{
						B[le2 - i] += 10;
						B[le2 - i - 1] -= 1;
					}
				}
				printf("-");
				for (i = 0; i < le2; i++)
				{
					if (B[i + 1] == 0 && check == 0)
						continue;
					else
					{
						check = 1;
						printf("%d", B[i + 1]);
					}
				}
				printf("\n");
			}
			else if (strcmp(A, B + 1) == 1) //A의 절댓값이 B의 절댓값보다 크다면
			{
				for (i = 0; i < le1; i++)
				{
					A[le1 - i - 1] = A[le1 - i - 1] - B[le2 - i];
					if (A[le1 - i - 1] < 0)
					{
						A[le1 - i - 1] += 10;
						A[le1 - i - 2] -= 1;
					}
				}
				for (i = 0; i < le1; i++)
				{
					if (A[i] == 0 && check == 0)
						continue;
					else
					{
						check = 1;
						printf("%d", A[i]);
					}
				}
				printf("\n");
			}
			else if (strcmp(A, B + 1) == -1) //A의 절댓값이 B의 절댓값보다 작다면
			{
				for (i = 0; i < le2; i++)
				{
					B[le2 - i] = B[le2 - i] - A[le1 - i - 1];
					if (B[le2 - i] < 0)
					{
						B[le2 - i] += 10;
						B[le2 - i - 1] -= 1;
					}
				}
				printf("-");
				for (i = 0; i < le2; i++)
				{
					if (B[i + 1] == 0 && check == 0)
						continue;
					else
					{
						check = 1;
						printf("%d", B[i + 1]);
					}
				}
				printf("\n");
			}
			else//두 수의 절댓값이 같다면
				printf("0\n");
		}
		else//A, B 모두 양수
		{
			len1 = le1 = strlen(A);
			len2 = le2 = strlen(B);
			for (i = 0; i < le1; i++)
				A[i] -= 48;
			for (i = 0; i < le2; i++)
				B[i] -= 48;
			if (len1 >= len2)
			{
				for (i = 0; i < len2; i++)
				{
					A[le1 - i - 1] = A[le1 - i - 1] + B[le2 - i - 1];
					if (A[le1 - i - 1] >= 10)
					{
						if (le1 - i - 1 == 0)
							continue;
						c = A[le1 - i - 1] / 10;
						A[le1 - i - 1] -= c * 10;
						A[le1 - i - 2] += c;
					}
				}
				for (; i < len1; i++)//음수에서와 같습니다.
				{
					if (A[le1 - i - 1] >= 10)
					{
						if (le1 - i - 1 == 0)
							continue;
						c = A[le1 - i - 1] / 10;
						A[le1 - i - 1] -= c * 10;
						A[le1 - i - 2] += c;
					}
				}
				for (i = 0; i < len1; i++)
					printf("%d", A[i]);
			}
			else
			{
				for (i = 0; i < len1; i++)
				{
					B[le2 - i - 1] = B[le2 - i - 1] + A[le1 - i - 1];
					if (B[le2 - i - 1] >= 10)
					{
						if (le2 - i - 1 == 0)
							continue;
						c = B[le2 - i - 1] / 10;
						B[le2 - i - 1] -= c * 10;
						B[le2 - i - 2] += c;
					}
				}
				for (; i < len2; i++)//음수에서와 같습니다.
				{
					if (B[le2 - i - 1] >= 10)
					{
						if (le2 - i - 1 == 0)
							continue;
						c = B[le2 - i - 1] / 10;
						B[le2 - i - 1] -= c * 10;
						B[le2 - i - 2] += c;
					}
				}
				for (i = 0; i < le2; i++)
					printf("%d", B[i]);
			}
			printf("\n");
		}
	}
	check = 0;
	return 0;
}