/*
 * Kubernetes
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1.10.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.suneee.kubernetes.model.volume;

import com.google.gson.annotations.SerializedName;
import com.suneee.kubernetes.model.*;
import com.suneee.kubernetes.model.azure.V1AzureDiskVolumeSource;
import com.suneee.kubernetes.model.azure.V1AzureFileVolumeSource;
import com.suneee.kubernetes.model.cephfs.V1CephFSVolumeSource;
import com.suneee.kubernetes.model.configmap.V1ConfigMapVolumeSource;
import com.suneee.kubernetes.model.downwardapi.V1DownwardAPIVolumeSource;
import com.suneee.kubernetes.model.iscsi.V1ISCSIVolumeSource;
import com.suneee.kubernetes.model.persistentvolume.V1PersistentVolumeClaimVolumeSource;
import com.suneee.kubernetes.model.rbd.V1RBDVolumeSource;
import com.suneee.kubernetes.model.secret.V1SecretVolumeSource;
import com.suneee.kubernetes.model.storage.V1StorageOSVolumeSource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Volume represents a named volume in a pod that may be accessed by any container in the pod.
 */
@ApiModel(description = "Volume represents a named volume in a pod that may be accessed by any container in the pod.")

public class V1Volume {
  @SerializedName("awsElasticBlockStore")
  private V1AWSElasticBlockStoreVolumeSource awsElasticBlockStore = null;

  @SerializedName("azureDisk")
  private V1AzureDiskVolumeSource azureDisk = null;

  @SerializedName("azureFile")
  private V1AzureFileVolumeSource azureFile = null;

  @SerializedName("cephfs")
  private V1CephFSVolumeSource cephfs = null;

  @SerializedName("cinder")
  private V1CinderVolumeSource cinder = null;

  @SerializedName("configMap")
  private V1ConfigMapVolumeSource configMap = null;

  @SerializedName("downwardAPI")
  private V1DownwardAPIVolumeSource downwardAPI = null;

  @SerializedName("emptyDir")
  private V1EmptyDirVolumeSource emptyDir = null;

  @SerializedName("fc")
  private V1FCVolumeSource fc = null;

  @SerializedName("flexVolume")
  private V1FlexVolumeSource flexVolume = null;

  @SerializedName("flocker")
  private V1FlockerVolumeSource flocker = null;

  @SerializedName("gcePersistentDisk")
  private V1GCEPersistentDiskVolumeSource gcePersistentDisk = null;

  @SerializedName("gitRepo")
  private V1GitRepoVolumeSource gitRepo = null;

  @SerializedName("glusterfs")
  private V1GlusterfsVolumeSource glusterfs = null;

  @SerializedName("hostPath")
  private V1HostPathVolumeSource hostPath = null;

  @SerializedName("iscsi")
  private V1ISCSIVolumeSource iscsi = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("nfs")
  private V1NFSVolumeSource nfs = null;

  @SerializedName("persistentVolumeClaim")
  private V1PersistentVolumeClaimVolumeSource persistentVolumeClaim = null;

  @SerializedName("photonPersistentDisk")
  private V1PhotonPersistentDiskVolumeSource photonPersistentDisk = null;

  @SerializedName("portworxVolume")
  private V1PortworxVolumeSource portworxVolume = null;

  @SerializedName("projected")
  private V1ProjectedVolumeSource projected = null;

  @SerializedName("quobyte")
  private V1QuobyteVolumeSource quobyte = null;

  @SerializedName("rbd")
  private V1RBDVolumeSource rbd = null;

  @SerializedName("scaleIO")
  private V1ScaleIOVolumeSource scaleIO = null;

  @SerializedName("secret")
  private V1SecretVolumeSource secret = null;

  @SerializedName("storageos")
  private V1StorageOSVolumeSource storageos = null;

  @SerializedName("vsphereVolume")
  private V1VsphereVirtualDiskVolumeSource vsphereVolume = null;

  public V1Volume awsElasticBlockStore(V1AWSElasticBlockStoreVolumeSource awsElasticBlockStore) {
    this.awsElasticBlockStore = awsElasticBlockStore;
    return this;
  }

   /**
   * AWSElasticBlockStore represents an AWS Disk resource that is attached to a kubelet&#39;s host machine and then exposed to the pod. More info: https://kubernetes.io/docs/concepts/storage/volumes#awselasticblockstore
   * @return awsElasticBlockStore
  **/
  @ApiModelProperty(value = "AWSElasticBlockStore represents an AWS Disk resource that is attached to a kubelet's host machine and then exposed to the pod. More info: https://kubernetes.io/docs/concepts/storage/volumes#awselasticblockstore")
  public V1AWSElasticBlockStoreVolumeSource getAwsElasticBlockStore() {
    return awsElasticBlockStore;
  }

  public void setAwsElasticBlockStore(V1AWSElasticBlockStoreVolumeSource awsElasticBlockStore) {
    this.awsElasticBlockStore = awsElasticBlockStore;
  }

  public V1Volume azureDisk(V1AzureDiskVolumeSource azureDisk) {
    this.azureDisk = azureDisk;
    return this;
  }

   /**
   * AzureDisk represents an Azure Data Disk mount on the host and bind mount to the pod.
   * @return azureDisk
  **/
  @ApiModelProperty(value = "AzureDisk represents an Azure Data Disk mount on the host and bind mount to the pod.")
  public V1AzureDiskVolumeSource getAzureDisk() {
    return azureDisk;
  }

  public void setAzureDisk(V1AzureDiskVolumeSource azureDisk) {
    this.azureDisk = azureDisk;
  }

  public V1Volume azureFile(V1AzureFileVolumeSource azureFile) {
    this.azureFile = azureFile;
    return this;
  }

   /**
   * AzureFile represents an Azure File Service mount on the host and bind mount to the pod.
   * @return azureFile
  **/
  @ApiModelProperty(value = "AzureFile represents an Azure File Service mount on the host and bind mount to the pod.")
  public V1AzureFileVolumeSource getAzureFile() {
    return azureFile;
  }

  public void setAzureFile(V1AzureFileVolumeSource azureFile) {
    this.azureFile = azureFile;
  }

  public V1Volume cephfs(V1CephFSVolumeSource cephfs) {
    this.cephfs = cephfs;
    return this;
  }

   /**
   * CephFS represents a Ceph FS mount on the host that shares a pod&#39;s lifetime
   * @return cephfs
  **/
  @ApiModelProperty(value = "CephFS represents a Ceph FS mount on the host that shares a pod's lifetime")
  public V1CephFSVolumeSource getCephfs() {
    return cephfs;
  }

  public void setCephfs(V1CephFSVolumeSource cephfs) {
    this.cephfs = cephfs;
  }

  public V1Volume cinder(V1CinderVolumeSource cinder) {
    this.cinder = cinder;
    return this;
  }

   /**
   * Cinder represents a cinder volume attached and mounted on kubelets host machine More info: https://releases.k8s.io/HEAD/examples/mysql-cinder-pd/README.md
   * @return cinder
  **/
  @ApiModelProperty(value = "Cinder represents a cinder volume attached and mounted on kubelets host machine More info: https://releases.k8s.io/HEAD/examples/mysql-cinder-pd/README.md")
  public V1CinderVolumeSource getCinder() {
    return cinder;
  }

  public void setCinder(V1CinderVolumeSource cinder) {
    this.cinder = cinder;
  }

  public V1Volume configMap(V1ConfigMapVolumeSource configMap) {
    this.configMap = configMap;
    return this;
  }

   /**
   * ConfigMap represents a configMap that should populate this volume
   * @return configMap
  **/
  @ApiModelProperty(value = "ConfigMap represents a configMap that should populate this volume")
  public V1ConfigMapVolumeSource getConfigMap() {
    return configMap;
  }

  public void setConfigMap(V1ConfigMapVolumeSource configMap) {
    this.configMap = configMap;
  }

  public V1Volume downwardAPI(V1DownwardAPIVolumeSource downwardAPI) {
    this.downwardAPI = downwardAPI;
    return this;
  }

   /**
   * DownwardAPI represents downward API about the pod that should populate this volume
   * @return downwardAPI
  **/
  @ApiModelProperty(value = "DownwardAPI represents downward API about the pod that should populate this volume")
  public V1DownwardAPIVolumeSource getDownwardAPI() {
    return downwardAPI;
  }

  public void setDownwardAPI(V1DownwardAPIVolumeSource downwardAPI) {
    this.downwardAPI = downwardAPI;
  }

  public V1Volume emptyDir(V1EmptyDirVolumeSource emptyDir) {
    this.emptyDir = emptyDir;
    return this;
  }

   /**
   * EmptyDir represents a temporary directory that shares a pod&#39;s lifetime. More info: https://kubernetes.io/docs/concepts/storage/volumes#emptydir
   * @return emptyDir
  **/
  @ApiModelProperty(value = "EmptyDir represents a temporary directory that shares a pod's lifetime. More info: https://kubernetes.io/docs/concepts/storage/volumes#emptydir")
  public V1EmptyDirVolumeSource getEmptyDir() {
    return emptyDir;
  }

  public void setEmptyDir(V1EmptyDirVolumeSource emptyDir) {
    this.emptyDir = emptyDir;
  }

  public V1Volume fc(V1FCVolumeSource fc) {
    this.fc = fc;
    return this;
  }

   /**
   * FC represents a Fibre Channel resource that is attached to a kubelet&#39;s host machine and then exposed to the pod.
   * @return fc
  **/
  @ApiModelProperty(value = "FC represents a Fibre Channel resource that is attached to a kubelet's host machine and then exposed to the pod.")
  public V1FCVolumeSource getFc() {
    return fc;
  }

  public void setFc(V1FCVolumeSource fc) {
    this.fc = fc;
  }

  public V1Volume flexVolume(V1FlexVolumeSource flexVolume) {
    this.flexVolume = flexVolume;
    return this;
  }

   /**
   * FlexVolume represents a generic volume resource that is provisioned/attached using an exec based plugin.
   * @return flexVolume
  **/
  @ApiModelProperty(value = "FlexVolume represents a generic volume resource that is provisioned/attached using an exec based plugin.")
  public V1FlexVolumeSource getFlexVolume() {
    return flexVolume;
  }

  public void setFlexVolume(V1FlexVolumeSource flexVolume) {
    this.flexVolume = flexVolume;
  }

  public V1Volume flocker(V1FlockerVolumeSource flocker) {
    this.flocker = flocker;
    return this;
  }

   /**
   * Flocker represents a Flocker volume attached to a kubelet&#39;s host machine. This depends on the Flocker control service being running
   * @return flocker
  **/
  @ApiModelProperty(value = "Flocker represents a Flocker volume attached to a kubelet's host machine. This depends on the Flocker control service being running")
  public V1FlockerVolumeSource getFlocker() {
    return flocker;
  }

  public void setFlocker(V1FlockerVolumeSource flocker) {
    this.flocker = flocker;
  }

  public V1Volume gcePersistentDisk(V1GCEPersistentDiskVolumeSource gcePersistentDisk) {
    this.gcePersistentDisk = gcePersistentDisk;
    return this;
  }

   /**
   * GCEPersistentDisk represents a GCE Disk resource that is attached to a kubelet&#39;s host machine and then exposed to the pod. More info: https://kubernetes.io/docs/concepts/storage/volumes#gcepersistentdisk
   * @return gcePersistentDisk
  **/
  @ApiModelProperty(value = "GCEPersistentDisk represents a GCE Disk resource that is attached to a kubelet's host machine and then exposed to the pod. More info: https://kubernetes.io/docs/concepts/storage/volumes#gcepersistentdisk")
  public V1GCEPersistentDiskVolumeSource getGcePersistentDisk() {
    return gcePersistentDisk;
  }

  public void setGcePersistentDisk(V1GCEPersistentDiskVolumeSource gcePersistentDisk) {
    this.gcePersistentDisk = gcePersistentDisk;
  }

  public V1Volume gitRepo(V1GitRepoVolumeSource gitRepo) {
    this.gitRepo = gitRepo;
    return this;
  }

   /**
   * GitRepo represents a git repository at a particular revision.
   * @return gitRepo
  **/
  @ApiModelProperty(value = "GitRepo represents a git repository at a particular revision.")
  public V1GitRepoVolumeSource getGitRepo() {
    return gitRepo;
  }

  public void setGitRepo(V1GitRepoVolumeSource gitRepo) {
    this.gitRepo = gitRepo;
  }

  public V1Volume glusterfs(V1GlusterfsVolumeSource glusterfs) {
    this.glusterfs = glusterfs;
    return this;
  }

   /**
   * Glusterfs represents a Glusterfs mount on the host that shares a pod&#39;s lifetime. More info: https://releases.k8s.io/HEAD/examples/volumes/glusterfs/README.md
   * @return glusterfs
  **/
  @ApiModelProperty(value = "Glusterfs represents a Glusterfs mount on the host that shares a pod's lifetime. More info: https://releases.k8s.io/HEAD/examples/volumes/glusterfs/README.md")
  public V1GlusterfsVolumeSource getGlusterfs() {
    return glusterfs;
  }

  public void setGlusterfs(V1GlusterfsVolumeSource glusterfs) {
    this.glusterfs = glusterfs;
  }

  public V1Volume hostPath(V1HostPathVolumeSource hostPath) {
    this.hostPath = hostPath;
    return this;
  }

   /**
   * HostPath represents a pre-existing file or directory on the host machine that is directly exposed to the container. This is generally used for system agents or other privileged things that are allowed to see the host machine. Most containers will NOT need this. More info: https://kubernetes.io/docs/concepts/storage/volumes#hostpath
   * @return hostPath
  **/
  @ApiModelProperty(value = "HostPath represents a pre-existing file or directory on the host machine that is directly exposed to the container. This is generally used for system agents or other privileged things that are allowed to see the host machine. Most containers will NOT need this. More info: https://kubernetes.io/docs/concepts/storage/volumes#hostpath")
  public V1HostPathVolumeSource getHostPath() {
    return hostPath;
  }

  public void setHostPath(V1HostPathVolumeSource hostPath) {
    this.hostPath = hostPath;
  }

  public V1Volume iscsi(V1ISCSIVolumeSource iscsi) {
    this.iscsi = iscsi;
    return this;
  }

   /**
   * ISCSI represents an ISCSI Disk resource that is attached to a kubelet&#39;s host machine and then exposed to the pod. More info: https://releases.k8s.io/HEAD/examples/volumes/iscsi/README.md
   * @return iscsi
  **/
  @ApiModelProperty(value = "ISCSI represents an ISCSI Disk resource that is attached to a kubelet's host machine and then exposed to the pod. More info: https://releases.k8s.io/HEAD/examples/volumes/iscsi/README.md")
  public V1ISCSIVolumeSource getIscsi() {
    return iscsi;
  }

  public void setIscsi(V1ISCSIVolumeSource iscsi) {
    this.iscsi = iscsi;
  }

  public V1Volume name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Volume&#39;s name. Must be a DNS_LABEL and unique within the pod. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Volume's name. Must be a DNS_LABEL and unique within the pod. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public V1Volume nfs(V1NFSVolumeSource nfs) {
    this.nfs = nfs;
    return this;
  }

   /**
   * NFS represents an NFS mount on the host that shares a pod&#39;s lifetime More info: https://kubernetes.io/docs/concepts/storage/volumes#nfs
   * @return nfs
  **/
  @ApiModelProperty(value = "NFS represents an NFS mount on the host that shares a pod's lifetime More info: https://kubernetes.io/docs/concepts/storage/volumes#nfs")
  public V1NFSVolumeSource getNfs() {
    return nfs;
  }

  public void setNfs(V1NFSVolumeSource nfs) {
    this.nfs = nfs;
  }

  public V1Volume persistentVolumeClaim(V1PersistentVolumeClaimVolumeSource persistentVolumeClaim) {
    this.persistentVolumeClaim = persistentVolumeClaim;
    return this;
  }

   /**
   * PersistentVolumeClaimVolumeSource represents a reference to a PersistentVolumeClaim in the same namespace. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#persistentvolumeclaims
   * @return persistentVolumeClaim
  **/
  @ApiModelProperty(value = "PersistentVolumeClaimVolumeSource represents a reference to a PersistentVolumeClaim in the same namespace. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#persistentvolumeclaims")
  public V1PersistentVolumeClaimVolumeSource getPersistentVolumeClaim() {
    return persistentVolumeClaim;
  }

  public void setPersistentVolumeClaim(V1PersistentVolumeClaimVolumeSource persistentVolumeClaim) {
    this.persistentVolumeClaim = persistentVolumeClaim;
  }

  public V1Volume photonPersistentDisk(V1PhotonPersistentDiskVolumeSource photonPersistentDisk) {
    this.photonPersistentDisk = photonPersistentDisk;
    return this;
  }

   /**
   * PhotonPersistentDisk represents a PhotonController persistent disk attached and mounted on kubelets host machine
   * @return photonPersistentDisk
  **/
  @ApiModelProperty(value = "PhotonPersistentDisk represents a PhotonController persistent disk attached and mounted on kubelets host machine")
  public V1PhotonPersistentDiskVolumeSource getPhotonPersistentDisk() {
    return photonPersistentDisk;
  }

  public void setPhotonPersistentDisk(V1PhotonPersistentDiskVolumeSource photonPersistentDisk) {
    this.photonPersistentDisk = photonPersistentDisk;
  }

  public V1Volume portworxVolume(V1PortworxVolumeSource portworxVolume) {
    this.portworxVolume = portworxVolume;
    return this;
  }

   /**
   * PortworxVolume represents a portworx volume attached and mounted on kubelets host machine
   * @return portworxVolume
  **/
  @ApiModelProperty(value = "PortworxVolume represents a portworx volume attached and mounted on kubelets host machine")
  public V1PortworxVolumeSource getPortworxVolume() {
    return portworxVolume;
  }

  public void setPortworxVolume(V1PortworxVolumeSource portworxVolume) {
    this.portworxVolume = portworxVolume;
  }

  public V1Volume projected(V1ProjectedVolumeSource projected) {
    this.projected = projected;
    return this;
  }

   /**
   * Items for all in one resources secrets, configmaps, and downward API
   * @return projected
  **/
  @ApiModelProperty(value = "Items for all in one resources secrets, configmaps, and downward API")
  public V1ProjectedVolumeSource getProjected() {
    return projected;
  }

  public void setProjected(V1ProjectedVolumeSource projected) {
    this.projected = projected;
  }

  public V1Volume quobyte(V1QuobyteVolumeSource quobyte) {
    this.quobyte = quobyte;
    return this;
  }

   /**
   * Quobyte represents a Quobyte mount on the host that shares a pod&#39;s lifetime
   * @return quobyte
  **/
  @ApiModelProperty(value = "Quobyte represents a Quobyte mount on the host that shares a pod's lifetime")
  public V1QuobyteVolumeSource getQuobyte() {
    return quobyte;
  }

  public void setQuobyte(V1QuobyteVolumeSource quobyte) {
    this.quobyte = quobyte;
  }

  public V1Volume rbd(V1RBDVolumeSource rbd) {
    this.rbd = rbd;
    return this;
  }

   /**
   * RBD represents a Rados Block Device mount on the host that shares a pod&#39;s lifetime. More info: https://releases.k8s.io/HEAD/examples/volumes/rbd/README.md
   * @return rbd
  **/
  @ApiModelProperty(value = "RBD represents a Rados Block Device mount on the host that shares a pod's lifetime. More info: https://releases.k8s.io/HEAD/examples/volumes/rbd/README.md")
  public V1RBDVolumeSource getRbd() {
    return rbd;
  }

  public void setRbd(V1RBDVolumeSource rbd) {
    this.rbd = rbd;
  }

  public V1Volume scaleIO(V1ScaleIOVolumeSource scaleIO) {
    this.scaleIO = scaleIO;
    return this;
  }

   /**
   * ScaleIO represents a ScaleIO persistent volume attached and mounted on Kubernetes nodes.
   * @return scaleIO
  **/
  @ApiModelProperty(value = "ScaleIO represents a ScaleIO persistent volume attached and mounted on Kubernetes nodes.")
  public V1ScaleIOVolumeSource getScaleIO() {
    return scaleIO;
  }

  public void setScaleIO(V1ScaleIOVolumeSource scaleIO) {
    this.scaleIO = scaleIO;
  }

  public V1Volume secret(V1SecretVolumeSource secret) {
    this.secret = secret;
    return this;
  }

   /**
   * Secret represents a secret that should populate this volume. More info: https://kubernetes.io/docs/concepts/storage/volumes#secret
   * @return secret
  **/
  @ApiModelProperty(value = "Secret represents a secret that should populate this volume. More info: https://kubernetes.io/docs/concepts/storage/volumes#secret")
  public V1SecretVolumeSource getSecret() {
    return secret;
  }

  public void setSecret(V1SecretVolumeSource secret) {
    this.secret = secret;
  }

  public V1Volume storageos(V1StorageOSVolumeSource storageos) {
    this.storageos = storageos;
    return this;
  }

   /**
   * StorageOS represents a StorageOS volume attached and mounted on Kubernetes nodes.
   * @return storageos
  **/
  @ApiModelProperty(value = "StorageOS represents a StorageOS volume attached and mounted on Kubernetes nodes.")
  public V1StorageOSVolumeSource getStorageos() {
    return storageos;
  }

  public void setStorageos(V1StorageOSVolumeSource storageos) {
    this.storageos = storageos;
  }

  public V1Volume vsphereVolume(V1VsphereVirtualDiskVolumeSource vsphereVolume) {
    this.vsphereVolume = vsphereVolume;
    return this;
  }

   /**
   * VsphereVolume represents a vSphere volume attached and mounted on kubelets host machine
   * @return vsphereVolume
  **/
  @ApiModelProperty(value = "VsphereVolume represents a vSphere volume attached and mounted on kubelets host machine")
  public V1VsphereVirtualDiskVolumeSource getVsphereVolume() {
    return vsphereVolume;
  }

  public void setVsphereVolume(V1VsphereVirtualDiskVolumeSource vsphereVolume) {
    this.vsphereVolume = vsphereVolume;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1Volume v1Volume = (V1Volume) o;
    return Objects.equals(this.awsElasticBlockStore, v1Volume.awsElasticBlockStore) &&
        Objects.equals(this.azureDisk, v1Volume.azureDisk) &&
        Objects.equals(this.azureFile, v1Volume.azureFile) &&
        Objects.equals(this.cephfs, v1Volume.cephfs) &&
        Objects.equals(this.cinder, v1Volume.cinder) &&
        Objects.equals(this.configMap, v1Volume.configMap) &&
        Objects.equals(this.downwardAPI, v1Volume.downwardAPI) &&
        Objects.equals(this.emptyDir, v1Volume.emptyDir) &&
        Objects.equals(this.fc, v1Volume.fc) &&
        Objects.equals(this.flexVolume, v1Volume.flexVolume) &&
        Objects.equals(this.flocker, v1Volume.flocker) &&
        Objects.equals(this.gcePersistentDisk, v1Volume.gcePersistentDisk) &&
        Objects.equals(this.gitRepo, v1Volume.gitRepo) &&
        Objects.equals(this.glusterfs, v1Volume.glusterfs) &&
        Objects.equals(this.hostPath, v1Volume.hostPath) &&
        Objects.equals(this.iscsi, v1Volume.iscsi) &&
        Objects.equals(this.name, v1Volume.name) &&
        Objects.equals(this.nfs, v1Volume.nfs) &&
        Objects.equals(this.persistentVolumeClaim, v1Volume.persistentVolumeClaim) &&
        Objects.equals(this.photonPersistentDisk, v1Volume.photonPersistentDisk) &&
        Objects.equals(this.portworxVolume, v1Volume.portworxVolume) &&
        Objects.equals(this.projected, v1Volume.projected) &&
        Objects.equals(this.quobyte, v1Volume.quobyte) &&
        Objects.equals(this.rbd, v1Volume.rbd) &&
        Objects.equals(this.scaleIO, v1Volume.scaleIO) &&
        Objects.equals(this.secret, v1Volume.secret) &&
        Objects.equals(this.storageos, v1Volume.storageos) &&
        Objects.equals(this.vsphereVolume, v1Volume.vsphereVolume);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awsElasticBlockStore, azureDisk, azureFile, cephfs, cinder, configMap, downwardAPI, emptyDir, fc, flexVolume, flocker, gcePersistentDisk, gitRepo, glusterfs, hostPath, iscsi, name, nfs, persistentVolumeClaim, photonPersistentDisk, portworxVolume, projected, quobyte, rbd, scaleIO, secret, storageos, vsphereVolume);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Volume {\n");

    sb.append("    awsElasticBlockStore: ").append(toIndentedString(awsElasticBlockStore)).append("\n");
    sb.append("    azureDisk: ").append(toIndentedString(azureDisk)).append("\n");
    sb.append("    azureFile: ").append(toIndentedString(azureFile)).append("\n");
    sb.append("    cephfs: ").append(toIndentedString(cephfs)).append("\n");
    sb.append("    cinder: ").append(toIndentedString(cinder)).append("\n");
    sb.append("    configMap: ").append(toIndentedString(configMap)).append("\n");
    sb.append("    downwardAPI: ").append(toIndentedString(downwardAPI)).append("\n");
    sb.append("    emptyDir: ").append(toIndentedString(emptyDir)).append("\n");
    sb.append("    fc: ").append(toIndentedString(fc)).append("\n");
    sb.append("    flexVolume: ").append(toIndentedString(flexVolume)).append("\n");
    sb.append("    flocker: ").append(toIndentedString(flocker)).append("\n");
    sb.append("    gcePersistentDisk: ").append(toIndentedString(gcePersistentDisk)).append("\n");
    sb.append("    gitRepo: ").append(toIndentedString(gitRepo)).append("\n");
    sb.append("    glusterfs: ").append(toIndentedString(glusterfs)).append("\n");
    sb.append("    hostPath: ").append(toIndentedString(hostPath)).append("\n");
    sb.append("    iscsi: ").append(toIndentedString(iscsi)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nfs: ").append(toIndentedString(nfs)).append("\n");
    sb.append("    persistentVolumeClaim: ").append(toIndentedString(persistentVolumeClaim)).append("\n");
    sb.append("    photonPersistentDisk: ").append(toIndentedString(photonPersistentDisk)).append("\n");
    sb.append("    portworxVolume: ").append(toIndentedString(portworxVolume)).append("\n");
    sb.append("    projected: ").append(toIndentedString(projected)).append("\n");
    sb.append("    quobyte: ").append(toIndentedString(quobyte)).append("\n");
    sb.append("    rbd: ").append(toIndentedString(rbd)).append("\n");
    sb.append("    scaleIO: ").append(toIndentedString(scaleIO)).append("\n");
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
    sb.append("    storageos: ").append(toIndentedString(storageos)).append("\n");
    sb.append("    vsphereVolume: ").append(toIndentedString(vsphereVolume)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

