#include <stdio.h>
#include <string.h>
char A[100005], B[100005];
int main(void)
{
	int le1, le2, len1, len2, i, j, check = 0, c;
	scanf("%s %s", A, B);

	if (A[0] == '-')
	{
		if (B[0] == '-')//A, B ��� ����
		{
			len1 = le1 = strlen(A) - 1;
			len2 = le2 = strlen(B) - 1;
			for (i = 0; i < le1; i++)
				A[i + 1] -= 48;
			for (i = 0; i < le2; i++)
				B[i + 1] -= 48;
			if (len1 >= len2)//A�� B���� ���̰� ��ų� ���� ���
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
				for (; i < len1; i++)//�ش� ������ ���� ���� �ٱ����� �ڵ忡�� ���������� ������ �� ���� 10�� ��츦 ����ϱ� ���� �ڵ��Դϴ�.
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
			else//A�� B���� ���̰� ª�� ���(A, B��� ����)
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
				for (; i < len2; i++)//���������� �ٿ��� ������ ���� 10�� ����Դϴ�.
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
		else//A�� ����, B�� ���
		{
			len1 = le1 = strlen(A) - 1;
			len2 = le2 = strlen(B);
			for (i = 0; i < le1; i++)
				A[i + 1] -= 48;
			for (i = 0; i < le2; i++)
				B[i] -= 48;
			if (len1 > len2)//A�� ������ B�� ���񰪺��� ŭ�� �ڸ����� �� �� ������
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
			else if (len2 > len1)//B�� ������ A�� ���񰪺��� ŭ�� �ڸ����� �� �� �ִٸ�
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
			else if (strcmp(A + 1, B) == 1) //A�� ������ B�� ���񰪺��� ũ�ٸ�
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
			else if (strcmp(A + 1, B) == -1) //A�� ������ B�� ���񰪺��� �۴ٸ�
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
			else//�� ���� ������ ���ٸ�
				printf("0\n");
		}
	}
	else
	{
		if (B[0] == '-')//A�� ���, B�� ����
		{
			len1 = le1 = strlen(A);
			len2 = le2 = strlen(B) - 1;
			for (i = 0; i < le1; i++)
				A[i] -= 48;
			for (i = 0; i < le2; i++)
				B[i + 1] -= 48;
			if (len1 > len2)//A�� ������ B�� ���񰪺��� ŭ�� �ڸ����� �� �� ������
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
			else if (len2 > len1)//B�� ������ A�� ���񰪺��� ŭ�� �ڸ����� �� �� �ִٸ�
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
			else if (strcmp(A, B + 1) == 1) //A�� ������ B�� ���񰪺��� ũ�ٸ�
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
			else if (strcmp(A, B + 1) == -1) //A�� ������ B�� ���񰪺��� �۴ٸ�
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
			else//�� ���� ������ ���ٸ�
				printf("0\n");
		}
		else//A, B ��� ���
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
				for (; i < len1; i++)//���������� �����ϴ�.
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
				for (; i < len2; i++)//���������� �����ϴ�.
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