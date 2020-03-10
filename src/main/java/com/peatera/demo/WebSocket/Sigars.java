package com.peatera.demo.WebSocket;

import java.util.Properties;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peatera.demo.pojo.SysMessage;

@Component("sigars")
public class Sigars {
	public SysMessage getSysMessage(String path) {
		SysMessage msg = null;
		Properties props = System.getProperties();
		Sigar sigar = new Sigar();
		//DecimalFormat df=new DecimalFormat("0.00");
		//NumberFormat df = NumberFormat.getNumberInstance();
		//df.setMaximumFractionDigits(2);
		try {
			// cpu资源信息列表
			CpuInfo[] infos = sigar.getCpuInfoList();
			// cpu使用信息
			CpuPerc cpuPerc = sigar.getCpuPerc();
			// 内存
			Mem mem = sigar.getMem();

			// cpu总量
			int total = infos[0].getMhz();
			// cpu总使用率)
			double cpusUse = cpuPerc.getCombined();
			// cpu当前空闲
			double cpuSurplus = cpuPerc.getIdle();

			// 内存总量
			double memTotal = mem.getTotal() / 1024;
			// 内存使用量
			double memUse = mem.getUsed() / 1024;
			// 内存剩余量
			double menmSurplum = mem.getFree() / 1024;
			// 操作系统版本
			String os = props.getProperty("os.name");
			// jdk
			String jdk = props.getProperty("java.version");

			// 目录总空间
			Long CatalogTotal = sigar.getFileSystemUsage(path).getTotal() / 1024 / 1024;
			// 目录剩余空间
			Long CatalogUse = sigar.getFileSystemUsage(path).getUsed() / 1024 / 1024;
			// 目录剩余空间
			Long CatalogSurplus = sigar.getFileSystemUsage(path).getFree() / 1024 / 1024;
			
			//硬盘总量
			Long ygTotal=getDiskInfo(sigar)[0];
			//硬盘使用量
			Long ygUse=getDiskInfo(sigar)[1];
            msg=new SysMessage(total,cpusUse,cpuSurplus,memTotal,memUse,menmSurplum,CatalogTotal,CatalogUse,CatalogSurplus,os,jdk,ygTotal,ygUse);
           
           // System.out.println(msg.toString());
		} catch (SigarException e) {
			e.printStackTrace();
		}

		return msg;
	}
	//获取硬盘信息
	 public static long[] getDiskInfo(Sigar sigar) {
			long[] diskInfo = new long[2];
			try {
				FileSystem fslist[] = sigar.getFileSystemList();
				long diskTotal = 0;
				long diskUsed = 0;
				for (int i = 0; i < fslist.length; i++) {
					FileSystem fs = fslist[i];
					if (fs.getType() == 2) {// 只统计本地磁盘
						FileSystemUsage usage = sigar.getFileSystemUsage(fs.getDirName());
						diskTotal += usage.getTotal();
						diskUsed += usage.getUsed();
					}
				}
				diskInfo[0] = diskTotal/1024/1024;
				diskInfo[1] = diskUsed/1024/1024;
			} catch (SigarException e) {
				//LOG.error("获取磁盘信息错误：{}", e.getMessage(), e);
			}
			return diskInfo;
		}
}
