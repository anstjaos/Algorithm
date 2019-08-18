#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

typedef struct a {
	long long x;
	long long y;
	long long z;
	int num;
}planet;

typedef struct b {
	int from;
	int to;
	long long weight;
}mst;

int planetCount;
planet plaArr[1000001];
vector<mst> arr;
int parents[1000001];
int cnt = 0;
long long result = 0;

bool compx(const planet &p1, const planet &p2)
{
	return p1.x > p2.x;
}

bool compy(const planet &p1, const planet &p2)
{
	return p1.y > p2.y;
}

bool compz(const planet &p1, const planet &p2)
{
	return p1.z > p2.z;
}

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	long long pivot = arr[(leftIndex + rightIndex) / 2].weight;

	while (leftIndex <= rightIndex)
	{
		while (arr[leftIndex].weight < pivot) leftIndex++;
		while (arr[rightIndex].weight > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(arr[leftIndex], arr[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

void makeUnion(int x, int y)
{
	if (parents[x] < parents[y]) parents[x] = y;
	else parents[y] = x;
}

int findSet(int x)
{
	if (x == parents[x]) return x;
	else
	{
		parents[x] = findSet(parents[x]);
		return parents[x];
	}
}

int main()
{
	long long x, y, z;
	cin >> planetCount;
	for (int i = 1; i <= planetCount; i++) parents[i] = i;
	for (int i = 1; i <= planetCount; i++)
	{
		cin >> x >> y >> z;
		plaArr[i] = { x,y,z,i };
	}

	sort(plaArr +1, plaArr + planetCount+1, compx);
	for (int i = 1; i < planetCount; i++)
	{
		arr.push_back({plaArr[i].num, plaArr[i + 1].num,  abs(plaArr[i].x - plaArr[i + 1].x) });
	}

	sort(plaArr + 1, plaArr + planetCount + 1, compy);
	for (int i = 1; i < planetCount; i++)
	{
		arr.push_back({ plaArr[i].num, plaArr[i + 1].num, abs(plaArr[i].y - plaArr[i + 1].y) });
	}

	sort(plaArr + 1, plaArr + planetCount + 1, compz);
	for (int i = 1; i < planetCount; i++)
	{
		arr.push_back({ plaArr[i].num, plaArr[i + 1].num, abs(plaArr[i].z - plaArr[i + 1].z) });
	}
	/*
	for (int i = 0; i < planetCount - 1; i++)
	{
		for (int j = i + 1; j <= planetCount; j++)
		{
			long long weight;

			long long weightX = plaArr[i].x - plaArr[j].x;
			if (weightX < 0) weightX = weightX * (-1);

			long long weightY = plaArr[i].y - plaArr[j].y;
			if (weightY < 0) weightY = weightY * (-1);

			long long weightZ = plaArr[i].z - plaArr[j].z;
			if (weightZ < 0) weightZ = weightZ * (-1);

			weight = min(min(weightX, weightY), weightZ);

			arr.push_back({ i,j,weight });
		}
	}
	*/

	int size = arr.size();
	quickSort(0, size - 1);

	for (int i = 0; cnt != planetCount-1; i++)
	{

		int x = findSet(arr[i].from);
		int y = findSet(arr[i].to);

		if (x == y) continue;

		makeUnion(x, y);
		result = result + arr[i].weight;
		cnt++;
	}
	cout << result << endl;
	return 0;
}