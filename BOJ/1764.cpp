#include <iostream>
using namespace std;

char nonListen[500001][25], temp[25];
char result[500001][25];
int nonListenCnt, nonSeeCnt, resultCnt;

int strlen1(char* src)
{
	int cnt = 0;
	while (src[cnt] != '\0') cnt++;

	return cnt;
}

void strcpy1(char *tar, char* src)
{
	int srcLen = strlen1(src);

	for (int i = 0; i < srcLen; i++)
	{
		tar[i] = src[i];
	}
}

int strcompare(char *tar, char* src)
{
	int tarLen = strlen1(tar);
	int srcLen = strlen1(src);

	int tarIndex, srcIndex;
	tarIndex = srcIndex = 0;

	while (tarIndex < tarLen && srcIndex < srcLen)
	{
		if (tar[tarIndex] == src[srcIndex])
		{
			tarIndex++;
			srcIndex++;
		}
		else if (tar[tarIndex] < src[srcIndex]) return -1;
		else return 1;
	}

	if (tarIndex < tarLen && srcIndex >= srcLen) return 1;
	else if (tarIndex >= tarLen && srcIndex < srcLen) return -1;

	return 0;
}

void quickSort(char arr[500001][25],int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	char pivot[25];
	strcpy1(pivot, arr[(left + right) / 2]);
	
	while (leftIndex <= rightIndex)
	{
		while (strcompare(arr[leftIndex], pivot) == -1) leftIndex++;
		while (strcompare(arr[rightIndex], pivot) == 1) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(arr[leftIndex], arr[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(arr,left, rightIndex);
	if (leftIndex < right) quickSort(arr,leftIndex, right);
}

bool binarySearch(char *temp,int left, int right)
{
	while (left <= right)
	{
		int mid = (left + right) / 2;

		int check = strcompare(temp, nonListen[mid]);
		if (check == -1)
		{
			right = mid - 1;
		}
		else if (check == 1) left = mid + 1;
		else return true;
	}
	return false;
}

void initChar(char *src)
{
	int len = strlen1(src);
	for (int i = 0; i < len; i++) src[i] = '\0';
}

int main()
{
	cin >> nonListenCnt >> nonSeeCnt;

	for (int i = 0; i < nonListenCnt; i++)
	{
		cin >> nonListen[i];
	}
	quickSort(nonListen,0, nonListenCnt - 1);	// 정렬
	for (int i = 0; i < nonSeeCnt; i++) // binary search 동일시 result에 삽입
	{
		cin >> temp;
		if (binarySearch(temp, 0, nonListenCnt - 1) == true) strcpy1(result[resultCnt++],temp);
		initChar(temp);
	} 

	quickSort(result, 0, resultCnt - 1);
	cout << resultCnt << '\n';
	for (int i = 0; i < resultCnt; i++)
	{
		cout << result[i] << '\n';
	}

	return 0;
}