// 기존의 풀이 방식
//#include <iostream>
//using namespace std;
//
//bool set[25];
//char oper[20];
//int operCnt, num;
//
//int strLen1(char *src)
//{
//	int cnt = 0;
//	while (src[cnt] != '\0') cnt++;
//	return cnt;
//}
//
//bool strcmp1(char* tar, char* src)
//{
//	int tarLen = strLen1(tar);
//	int srcLen = strLen1(src);
//
//	if (tarLen != srcLen) return false;
//
//	int tarIndex = 0, srcIndex = 0;
//
//	while (tarIndex < tarLen && srcIndex < srcLen)
//	{
//		if (tar[tarIndex] == src[srcIndex])
//		{
//			tarIndex++;
//			srcIndex++;
//		}
//		else return false;
//	}
//	
//	return true;
//}
//
//int main()
//{
//	scanf("%d ",&operCnt);
//
//	for (int i = 0; i < operCnt; i++)
//	{
//		scanf("%s ", &oper);
//
//		if (strcmp1(oper,"add") == true)
//		{
//			scanf("%d ", &num);
//			set[num] = true;
//		}
//		else if (strcmp1(oper, "remove") == true)
//		{
//			scanf("%d ", &num);
//			set[num] = false;
//		}
//		else if (strcmp1(oper, "check") == true)
//		{
//			scanf("%d ", &num);
//			if (set[num] == true) cout << "1" << '\n';
//			else cout << "0" << '\n';
//		}
//		else if (strcmp1(oper, "toggle") == true)
//		{
//			scanf("%d ", &num);
//			set[num] = (set[num] * -1) + 1;
//		}
//		else if (strcmp1(oper, "all") == true)
//		{
//			for (int i = 1; i <= 20; i++) set[i] = true;
//		}
//		else if (strcmp1(oper, "empty") == true)
//		{
//			for (int i = 1; i <= 20; i++) set[i] = false;
//		}
//	}
//	return 0;
//}

// Bitmasking 사용
#include <cstdio>

int M, bitmask = (1 << 21), num;
char input[10];

bool strcmp(const char *str, int size)
{
	register int i = 0;
	for (; i < size; i++) {
		if (str[i] != input[i]) break;
	}

	if (i == size) return true;
	return false;
}

int main()
{
	scanf("%d", &M);
	for (register int i = 0; i < M; i++)
	{
		scanf("%s", input);
		if (strcmp("add", 3)) {
			scanf("%d", &num);
			bitmask = bitmask | (1 << num);
		}
		else if (strcmp("remove", 6)) {
			scanf("%d", &num);
			bitmask = bitmask & ~(1 << num);
		}
		else if (strcmp("check", 5)) {
			scanf("%d", &num);
			if (bitmask & (1 << num)) printf("1\n");
			else printf("0\n");
		}
		else if (strcmp("toggle", 6)) {
			scanf("%d", &num);
			if (bitmask & (1 << num)) bitmask = bitmask & ~(1 << num);
			else bitmask = bitmask | (1 << num);
		}
		else if (strcmp("all", 3)) {
			bitmask = (1 << 21) - 1;
		}
		else if (strcmp("empty", 5)) {
			bitmask = (1 << 21);
		}
	}
	return 0;
}