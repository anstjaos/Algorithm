#include <cstdio>
#include <algorithm>

int arr[3];
char input[5];

int main()
{
	for (register int i = 0; i < 3; i++) scanf("%d", arr + i);
	scanf("%s", input);
	std::sort(arr, arr + 3);

	for (register int i = 0; i < 3; i++) {
		printf("%d ", arr[input[i]-'A']);
	}
	printf("\n");
	return 0;
}