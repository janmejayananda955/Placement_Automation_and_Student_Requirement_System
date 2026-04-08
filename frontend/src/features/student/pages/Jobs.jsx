import React, { useState, useEffect } from "react";
import JobSearchBar from "../components/jobs/JobSearchBar";
import JobList from "../components/jobs/JobList";
import { toast } from "react-toastify";
import api from "../../../services/api";
import { useNavigate } from "react-router-dom";

const Jobs = () => {
  const navigate = useNavigate();
  const [searchTerm, setSearchTerm] = useState("");
  const [jobs, setJobs] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchJobs = async () => {
      try {
        const { data } = await api.get("/jobs");
        
        // Map backend payload to frontend expected fields
        const mappedJobs = data.map(job => ({
          id: job.id,
          title: job.role,
          company: "Not Provided", // Wait for backend to send Company Name or ID
          location: "Location TBA", 
          type: "Full-Time",
          salary: `₹${job.salary?.toLocaleString()}`,
          postedAt: "Recently", 
          experience: "Any",
          tags: job.skills || [],
          description: job.description,
          deadline: job.deadline,
        }));
        
        setJobs(mappedJobs);
      } catch (err) {
        console.error("Failed to fetch jobs:", err);
        toast.error("Failed to load jobs from server.");
      } finally {
        setLoading(false);
      }
    };

    fetchJobs();
  }, []);

  const filteredJobs = jobs.filter(job => 
    job.title?.toLowerCase().includes(searchTerm.toLowerCase()) || 
    job.company?.toLowerCase().includes(searchTerm.toLowerCase())
  );

  const handleApply = (job) => {
    navigate(`/student/jobs/${job.id}`);
  };

  return (
    <div className="space-y-8">
      <div>
        <h1 className="text-3xl font-bold text-slate-900 dark:text-white">Browse Jobs</h1>
        <p className="text-slate-500 dark:text-slate-400 mt-1">Discover and apply for your next career opportunity.</p>
      </div>

      <JobSearchBar searchTerm={searchTerm} setSearchTerm={setSearchTerm} />
      
      {loading ? (
        <div className="flex justify-center items-center py-20">
          <div className="animate-spin rounded-full h-10 w-10 border-b-2 border-blue-500"></div>
        </div>
      ) : (
        <JobList jobs={filteredJobs} onApply={handleApply} />
      )}
    </div>
  );
};

export default Jobs;
