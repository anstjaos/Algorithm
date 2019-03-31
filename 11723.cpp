#include <iostream>
using namespace std;

bool set[25];
char oper[20];
int operCnt, num;

int strLen1(char *src)
{
	int cnt = 0;
	while (src[cnt] != '\0') cnt++;
	return cnt;
}

bool strcmp1(char* tar, char* src)
{
	int tarLen = strLen1(tar);
	int srcLen = strLen1(src);

	if (tarLen != srcLen) return false;

	int tarIndex = 0, srcIndex = 0;

	while (tarIndex < tarLen && srcIndex < srcLen)
	{
		if (tar[tarIndex] == src[srcIndex])
		{
			tarIndex++;
			srcIndex++;
		}
		else return false;
	}
	
	return true;
}

int main()
{
	scanf("%d ",&operCnt);

	for (int i = 0; i < operCnt; i++)
	{
		scanf("%s ", &oper);

		if (strcmp1(oper,"add") == true)
		{
			scanf("%d ", &num);
			set[num] = true;
		}
		else if (strcmp1(oper, "remove") == true)
		{
			scanf("%d ", &num);
			set[num] = false;
		}
		else if (strcmp1(oper, "check") == true)
		{
			scanf("%d ", &num);
			if (set[num] == true) cout << "1" << '\n';
			else cout << "0" << '\n';
		}
		else if (strcmp1(oper, "toggle") == true)
		{
			scanf("%d ", &num);
			set[num] = (set[num] * -1) + 1;
		}
		else if (strcmp1(oper, "all") == true)
		{
			for (int i = 1; i <= 20; i++) set[i] = true;
		}
		else if (strcmp1(oper, "empty") == true)
		{
			for (int i = 1; i <= 20; i++) set[i] = false;
		}
	}
	return 0;
}