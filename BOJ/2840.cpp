#include <cstdio>

int N, K, idx, tempInt;
char tempChar, arr[30];
bool check[26], flag;

int main()
{
	scanf("%d %d", &N, &K);
	flag = true;
	for (register int i = 0; i < K; i++)
	{
		scanf("%d %c", &tempInt, &tempChar);
		idx = (idx + tempInt) % N;
		if (arr[idx] == '\0') {
			if (check[tempChar - 'A'] == true) {
				flag = false;
				break;
			}
			check[tempChar - 'A'] = true;
			arr[idx] = tempChar;
		}
		else if (arr[idx] != '\0' && arr[idx] != tempChar)
		{
			flag = false;
			break;
		}
	}

	if (flag == false) printf("!");
	else {
		int cnt = 0;
		while (cnt < N)
		{
			cnt++;
			arr[idx] == '\0' ? printf("?") : printf("%c", arr[idx]);
			idx = (idx - 1 + N) % N;
		}
	}
	printf("\n");
	return 0;
}